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
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.AzureResourceMonthlyUsageRecord;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="ResourceUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements operations related to a single subscription resource usage records.
 */
public class ResourceUsageRecordCollectionOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements IResourceUsageRecordCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #ResourceUsageRecordCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     * @param subscriptionId The subscription id.
     */
    public ResourceUsageRecordCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId,
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
     * Retrieves the subscription usage records.
     * 
     * @return Collection of subscription usage records.
     */
    @Override
    public ResourceCollection<AzureResourceMonthlyUsageRecord> get()
    {
        IPartnerServiceProxy<AzureResourceMonthlyUsageRecord, ResourceCollection<AzureResourceMonthlyUsageRecord>> partnerServiceProxy =
            new PartnerServiceProxy<AzureResourceMonthlyUsageRecord, ResourceCollection<AzureResourceMonthlyUsageRecord>>( new TypeReference<ResourceCollection<AzureResourceMonthlyUsageRecord>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetSubscriptionResourceUsageRecords" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

}
