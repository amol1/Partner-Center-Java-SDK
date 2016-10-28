package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class implements the operations for a customer's subscription.
 */
public class SubscriptionOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements ISubscriptionOperations
{
    private String customerId;

    private String subscriptionId;

    /**
     * A lazy reference to the current subscription's add-ons operations.
     */
    private ISubscriptionAddOnCollectionOperations subscriptionAddOnsOperations;

    /**
     * A lazy reference to the current subscription's upgrade operations.
     */
    private ISubscriptionUpgradeCollectionOperations subscriptionUpgradeOperations;

    /**
     * A lazy reference to the current subscription's resource usage records operations.
     */
    private IResourceUsageRecordCollectionOperations resourceUsageRecordsOperations;

    /**
     * A lazy reference to the current subscription's daily usage records operations.
     */
    private ISubscriptionDailyUsageRecordCollectionOperations subscriptionDailyUsageRecordsOperations;

    /**
     * A lazy reference to the current subscription's usage summary operations.
     */
    private ISubscriptionUsageSummaryOperations subscriptionUsageSummaryOperations;

    /**
     * Initializes a new instance of the {@link #SubscriptionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     * @param subscriptionId The subscription id.
     */
    public SubscriptionOperations( IPartnerOperations rootPartnerOperations, String customerId, String subscriptionId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( customerId, subscriptionId ) );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

        if ( StringHelper.isNullOrWhiteSpace( subscriptionId ) )
        {
            throw new IllegalArgumentException( "subscriptionId must be set." );
        }
        this.customerId = customerId;
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the current subscription's add-ons operations.
     */
    @Override
    public ISubscriptionAddOnCollectionOperations getAddOns()
    {
        if ( this.subscriptionAddOnsOperations == null )
        {
            this.subscriptionAddOnsOperations =
                new SubscriptionAddOnCollectionOperations( this.getPartner(), this.customerId, this.subscriptionId );
        }
        return this.subscriptionAddOnsOperations;
    }

    /**
     * Gets the current subscription's upgrade operations.
     */
    @Override
    public ISubscriptionUpgradeCollectionOperations getUpgrades()
    {
        if ( this.subscriptionUpgradeOperations == null )
        {
            this.subscriptionUpgradeOperations =
                new SubscriptionUpgradeCollectionOperations( this.getPartner(), this.customerId, this.subscriptionId );
        }
        return this.subscriptionUpgradeOperations;
    }

    /**
     * Gets the current subscription's usage records operations.
     */
    @Override
    public IResourceUsageRecordCollectionOperations getResourceUsageRecords()
    {
        if ( this.resourceUsageRecordsOperations == null )
        {
            this.resourceUsageRecordsOperations =
                new ResourceUsageRecordCollectionOperations( this.getPartner(), customerId, subscriptionId );
        }
        return this.resourceUsageRecordsOperations;
    }

    /**
     * Gets the current subscription's daily usage records operations.
     */
    @Override
    public ISubscriptionDailyUsageRecordCollectionOperations getDailyUsageRecords()
    {
        if ( this.subscriptionDailyUsageRecordsOperations == null )
        {
            this.subscriptionDailyUsageRecordsOperations =
                new SubscriptionDailyUsageRecordCollectionOperations( this.getPartner(), customerId, subscriptionId );
        }
        return this.subscriptionDailyUsageRecordsOperations;
    }

    /**
     * Gets the current subscription's usage summary operations.
     */
    @Override
    public ISubscriptionUsageSummaryOperations getUsageSummary()
    {
        if ( this.subscriptionUsageSummaryOperations == null )
        {
            this.subscriptionUsageSummaryOperations =
                new SubscriptionUsageSummaryOperations( this.getPartner(), customerId, subscriptionId );
        }
        return this.subscriptionUsageSummaryOperations;
    }

    /**
     * Gets the subscription.
     * 
     * @return The subscription.
     */
    @Override
    public Subscription get()
    {
        {
            IPartnerServiceProxy<Subscription, Subscription> partnerServiceProxy =
                new PartnerServiceProxy<Subscription, Subscription>( new TypeReference<Subscription>()
                {
                }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetSubscription" ).getPath(),
                                                            this.getContext().getItem1(), this.getContext().getItem2(),
                                                            Locale.US ) );
            return partnerServiceProxy.get();
        }
    }

    // await
    /**
     * Updates a subscription.
     * 
     * @param subscription The subscription information.
     * @return The updated subscription information.
     */
    @Override
    public Subscription update( Subscription subscription )
    {
        if ( subscription == null )
        {
            throw new IllegalArgumentException( "subscription is required." );
        }
        PartnerServiceProxy<Subscription, Subscription> partnerApiServiceProxy =
            new PartnerServiceProxy<Subscription, Subscription>( new TypeReference<Subscription>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "UpdateSubscription" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerApiServiceProxy.patch( subscription );
    }

}

// await