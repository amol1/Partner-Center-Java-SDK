package com.microsoft.univstore.partnercentersdk.core.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerUsageSummary;

// -----------------------------------------------------------------------
// <copyright file="ICustomerUsageSummaryOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This interface defines the operations available on a customer's usage summary.
 */
public interface ICustomerUsageSummaryOperations
    extends IPartnerComponentString, IEntityGetOperations<CustomerUsageSummary>
{
}
