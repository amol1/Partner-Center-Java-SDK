package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Upgrade;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.UpgradeResult;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionUpgradeCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The customer subscription upgrade implementation.
 */
public class SubscriptionUpgradeCollectionOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements ISubscriptionUpgradeCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #SubscriptionUpgradeCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id to whom the subscriptions belong.
     * @param subscriptionId The subscription Id where the upgrade is occurring.
     */
    public SubscriptionUpgradeCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId,
                                                    String subscriptionId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( customerId, subscriptionId ) );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId should be set." );
        }

        if ( StringHelper.isNullOrWhiteSpace( subscriptionId ) )
        {
            throw new IllegalArgumentException( "subscriptionId should be set." );
        }

    }

    /**
     * Retrieves all subscription upgrades.
     * 
     * @return The subscription upgrades.
     */
    @Override
    public ResourceCollection<Upgrade> get()
    {
        PartnerServiceProxy<Upgrade, ResourceCollection<Upgrade>> partnerServiceProxy =
            new PartnerServiceProxy<Upgrade, ResourceCollection<Upgrade>>( new TypeReference<ResourceCollection<Upgrade>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "PostSubscriptionUpgrade" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

    /**
     * Performs a subscription upgrade.
     * 
     * @param subscriptionUpgrade The subscription upgrade to perform.
     * @return A task containing the subscription upgrade result.
     */
    @Override
    public UpgradeResult create( Upgrade subscriptionUpgrade )
    {
        PartnerServiceProxy<Upgrade, UpgradeResult> partnerServiceProxy =
            new PartnerServiceProxy<Upgrade, UpgradeResult>( new TypeReference<UpgradeResult>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "PostSubscriptionUpgrade" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.post( subscriptionUpgrade );
    }

}
