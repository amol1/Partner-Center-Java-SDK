package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionUsageSummary;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionUsageSummaryOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class implements the operations for a customer's subscription.
 */
public class SubscriptionUsageSummaryOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements ISubscriptionUsageSummaryOperations
{
    /**
     * Initializes a new instance of the {@link #SubscriptionUsageSummaryOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     * @param subscriptionId The subscription id.
     */
    public SubscriptionUsageSummaryOperations( IPartnerOperations rootPartnerOperations, String customerId,
                                               String subscriptionId )
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

    }

    /**
     * Gets the subscription usage summary.
     * 
     * @return The subscription usage summary.
     */
    @Override
    public SubscriptionUsageSummary get()
    {

        PartnerServiceProxy<SubscriptionUsageSummary, SubscriptionUsageSummary> partnerServiceProxy =
            new PartnerServiceProxy<SubscriptionUsageSummary, SubscriptionUsageSummary>( new TypeReference<SubscriptionUsageSummary>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetSubscriptionUsageSummary" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

}
