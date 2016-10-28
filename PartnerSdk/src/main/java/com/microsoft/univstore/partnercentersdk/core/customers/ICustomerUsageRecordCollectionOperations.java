package com.microsoft.univstore.partnercentersdk.core.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerMonthlyUsageRecord;

// -----------------------------------------------------------------------
// <copyright file="ICustomerUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines the behavior of a customer usage record collection operations.
 */
public interface ICustomerUsageRecordCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<CustomerMonthlyUsageRecord, ResourceCollection<CustomerMonthlyUsageRecord>>
{
}
