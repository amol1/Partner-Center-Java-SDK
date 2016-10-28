package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.ParameterValidator;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The customer subscriptions implementation.
 */
public class SubscriptionCollectionOperations
    extends BasePartnerComponentString
    implements ISubscriptionCollectionOperations
{
    /**
     * A lazy reference to the current customer's subscription usage records operations.
     */
    private ISubscriptionUsageRecordCollectionOperations usageRecords;

    private String customerId;

    /**
     * Initializes a new instance of the {@link #SubscriptionCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id to whom the subscriptions belong.
     */
    public SubscriptionCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set" );
        }
        this.customerId = customerId;
    }

    /**
     * Obtains the subscription usage records behavior for the customer.
     *
     * @return The customer subscription usage records.
     */
    @Override
    public ISubscriptionUsageRecordCollectionOperations getUsageRecords()
    {
        if ( usageRecords == null )
        {
            usageRecords = new SubscriptionUsageRecordCollectionOperations( this.getPartner(), this.customerId );
        }
        return this.usageRecords;
    }

    /**
     * Groups customer subscriptions by an order.
     *
     * @param orderId The order id.
     * @return The order subscriptions operations.
     */
    @Override
    public IEntireEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>> byOrder( String orderId )
    {
        ParameterValidator.isValidUriQueryValue( orderId, "orderId is an invalid query value" );
        return new OrderSubscriptionCollectionOperations( this.getPartner(), this.getContext(), orderId );
    }

    /**
     * Groups customer subscriptions by a partner.
     *
     * @param partnerId The partner id.
     * @return The partner subscriptions operations.
     */
    @Override
    public IEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>> byPartner( String partnerId )
    {
        ParameterValidator.isValidUriQueryValue( partnerId, "partnerId is an invalid query value" );
        return new PartnerSubscriptionCollectionOperations( this.getPartner(), this.getContext(), partnerId );
    }

    /**
     * Retrieves a specific customer subscription behavior.
     *
     * @param subscriptionId The subscription id.
     * @return The customer subscription.
     */
    @Override
    public ISubscriptionOperations byId( String subscriptionId )
    {
        return new SubscriptionOperations( this.getPartner(), this.getContext(), subscriptionId );
    }

    //
    /**
     * Retrieves all subscriptions.
     * 
     * @return The subscriptions.
     */
    @Override
    public ResourceCollection<Subscription> get()
    {
        PartnerServiceProxy<Subscription, ResourceCollection<Subscription>> partnerServiceProxy =
            new PartnerServiceProxy<Subscription, ResourceCollection<Subscription>>( new TypeReference<ResourceCollection<Subscription>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptions" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }

}

// await