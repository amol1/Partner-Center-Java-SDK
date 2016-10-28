package com.microsoft.univstore.partnercentersdk.core.customers.profiles;

import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerCompanyProfile;

// -----------------------------------------------------------------------
// <copyright file="CustomerProfileCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements customer profile collection operations.
 */
public class CustomerProfileCollectionOperations
    extends BasePartnerComponentString
    implements ICustomerProfileCollectionOperations
{
    /**
     * A lazy reference to a customer billing operations instance.
     */
    private ICustomerProfileOperations<CustomerBillingProfile> billingProfileOperations;

    /**
     * A lazy reference to a customer company operations instance.
     */
    private ICustomerProfileOperations<CustomerCompanyProfile> companyProfileOperations;

    /**
     * Initializes a new instance of the {@link #CustomerProfileCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer tenant Id.
     */
    public CustomerProfileCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId can't be null" );
        }
    }

    /**
     * Gets the customer's billing profile operations.
     */
    @Override
    public ICustomerProfileOperations<CustomerBillingProfile> getBilling()
    {
        if ( this.billingProfileOperations == null )
            this.billingProfileOperations =
                new CustomerBillingProfileOperations( this.getPartner(), this.getContext() );
        return this.billingProfileOperations;
    }

    /**
     * Gets the customer's company profile operations.
     */
    @Override
    public ICustomerProfileOperations<CustomerCompanyProfile> getCompany()
    {
        if ( this.companyProfileOperations == null )
            this.companyProfileOperations =
                new CustomerCompanyProfileOperations( this.getPartner(), this.getContext() );
        return this.companyProfileOperations;
    }

}
