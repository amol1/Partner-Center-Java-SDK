package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionMonthlyUsageRecord;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements operations related to a single customer's subscription usage records.
 */
public class SubscriptionUsageRecordCollectionOperations
    extends BasePartnerComponentString
    implements ISubscriptionUsageRecordCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #SubscriptionUsageRecordCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     */
    public SubscriptionUsageRecordCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId should be set." );
        }

    }

    /**
     * Retrieves the subscription usage records.
     * 
     * @return Collection of subscription usage records.
     */
    @Override
    public ResourceCollection<SubscriptionMonthlyUsageRecord> get()
    {

        PartnerServiceProxy<SubscriptionMonthlyUsageRecord, ResourceCollection<SubscriptionMonthlyUsageRecord>> partnerServiceProxy =
            new PartnerServiceProxy<SubscriptionMonthlyUsageRecord, ResourceCollection<SubscriptionMonthlyUsageRecord>>( new TypeReference<ResourceCollection<SubscriptionMonthlyUsageRecord>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetSubscriptionUsageRecords" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }

}
