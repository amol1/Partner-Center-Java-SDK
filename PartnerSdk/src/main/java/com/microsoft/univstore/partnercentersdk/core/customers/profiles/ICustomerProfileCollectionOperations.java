package com.microsoft.univstore.partnercentersdk.core.customers.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerCompanyProfile;

// -----------------------------------------------------------------------
// <copyright file="ICustomerProfileCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents customer profiles behavior.
 */
public interface ICustomerProfileCollectionOperations
    extends IPartnerComponentString
{
    /**
     * Gets the customer's billing profile operations.
     */
    ICustomerProfileOperations<CustomerBillingProfile> getBilling();

    /**
     * Gets the customer's company profile operations.
     */
    ICustomerProfileOperations<CustomerCompanyProfile> getCompany();

}
