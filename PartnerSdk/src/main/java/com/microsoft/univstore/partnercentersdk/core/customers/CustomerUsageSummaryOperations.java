package com.microsoft.univstore.partnercentersdk.core.customers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerUsageSummary;

// -----------------------------------------------------------------------
// <copyright file="CustomerUsageSummaryOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class implements the operations for a customer's summary of usage-based subscriptions.
 */
public class CustomerUsageSummaryOperations
    extends BasePartnerComponentString
    implements ICustomerUsageSummaryOperations
{
    /**
     * Initializes a new instance of the {@link #CustomerUsageSummaryOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     */
    public CustomerUsageSummaryOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

    }

    /**
     * Gets the customer usage summary.
     * 
     * @return The customer usage summary.
     */
    @Override
    public CustomerUsageSummary get()
    {
        IPartnerServiceProxy<CustomerUsageSummary, CustomerUsageSummary> partnerServiceProxy =
            new PartnerServiceProxy<CustomerUsageSummary, CustomerUsageSummary>( new TypeReference<CustomerUsageSummary>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerUsageSummary" ).getPath(),
                                                        this.getContext(), Locale.US ) );

        return partnerServiceProxy.get();
    }

}
