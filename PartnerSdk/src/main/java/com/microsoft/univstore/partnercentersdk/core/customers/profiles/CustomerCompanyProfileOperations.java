package com.microsoft.univstore.partnercentersdk.core.customers.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerCompanyProfile;

// -----------------------------------------------------------------------
// <copyright file="CustomerCompanyProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements the customer company profile operations.
 */
public class CustomerCompanyProfileOperations
    extends BasePartnerComponentString
    implements ICustomerProfileOperations<CustomerCompanyProfile>
{
    /**
     * Initializes a new instance of the {@link #CustomerCompanyProfileOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer tenant Id.
     */
    public CustomerCompanyProfileOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId can't be null" );
        }

    }

    /**
     * Gets the customer's company profile.
     * 
     * @return The customer's company profile.
     */
    @Override
    public CustomerCompanyProfile get()
    {

        PartnerServiceProxy<CustomerCompanyProfile, CustomerCompanyProfile> partnerServiceProxy =
            new PartnerServiceProxy<CustomerCompanyProfile, CustomerCompanyProfile>( new TypeReference<CustomerCompanyProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerCompanyProfile" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }

    /**
     * Updates the customer's company profile.
     * 
     * @param companyProfile A customer company profile with updated fields.
     * @return The updated customer company profile.
     */
    public CustomerCompanyProfile update( CustomerCompanyProfile companyProfile )
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
