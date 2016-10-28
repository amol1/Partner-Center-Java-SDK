package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.AzureResourceMonthlyUsageRecord;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// <copyright file="IResourceUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines the behavior for a subscription's resource usage records.
 */
public interface IResourceUsageRecordCollectionOperations
    extends IPartnerComponent<Tuple<String, String>>,
    IEntireEntityCollectionRetrievalOperations<AzureResourceMonthlyUsageRecord, ResourceCollection<AzureResourceMonthlyUsageRecord>>
{
}
