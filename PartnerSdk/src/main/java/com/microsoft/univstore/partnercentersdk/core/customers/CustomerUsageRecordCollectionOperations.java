package com.microsoft.univstore.partnercentersdk.core.customers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerMonthlyUsageRecord;

// -----------------------------------------------------------------------
// <copyright file="CustomerUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements operations related to a partner's customers usage record.
 */
public class CustomerUsageRecordCollectionOperations
    extends BasePartnerComponentString
    implements ICustomerUsageRecordCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #CustomerUsageRecordCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public CustomerUsageRecordCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the collection of customer monthly usage records for a partner.
     * 
     * @return The collection of customer monthly usage records.
     */
    @Override
    public ResourceCollection<CustomerMonthlyUsageRecord> get()
    {
        IPartnerServiceProxy<CustomerMonthlyUsageRecord, ResourceCollection<CustomerMonthlyUsageRecord>> partnerServiceProxy =
            new PartnerServiceProxy<CustomerMonthlyUsageRecord, ResourceCollection<CustomerMonthlyUsageRecord>>( new TypeReference<ResourceCollection<CustomerMonthlyUsageRecord>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerUsageRecords" ).getPath(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

}
