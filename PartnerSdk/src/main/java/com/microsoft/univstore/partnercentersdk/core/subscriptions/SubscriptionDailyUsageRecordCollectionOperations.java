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
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionDailyUsageRecord;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionDailyUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements operations related to a single subscription daily usage records.
 */
public class SubscriptionDailyUsageRecordCollectionOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements ISubscriptionDailyUsageRecordCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #SubscriptionDailyUsageRecordCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     * @param subscriptionId The subscription id.
     */
    public SubscriptionDailyUsageRecordCollectionOperations( IPartnerOperations rootPartnerOperations,
                                                             String customerId, String subscriptionId )
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
     * Retrieves the subscription daily usage records.
     * 
     * @return Collection of subscription daily usage records.
     */
    @Override
    public ResourceCollection<SubscriptionDailyUsageRecord> get()
    {
        PartnerServiceProxy<SubscriptionDailyUsageRecord, ResourceCollection<SubscriptionDailyUsageRecord>> partnerServiceProxy =
            new PartnerServiceProxy<SubscriptionDailyUsageRecord, ResourceCollection<SubscriptionDailyUsageRecord>>( new TypeReference<ResourceCollection<SubscriptionDailyUsageRecord>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetSubscriptionDailyUsageRecords" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

}
