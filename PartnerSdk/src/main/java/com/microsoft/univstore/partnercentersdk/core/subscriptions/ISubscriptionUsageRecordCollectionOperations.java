package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionMonthlyUsageRecord;

// <copyright file="ISubscriptionUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines the behavior for a customer's subscription usage records.
 */
public interface ISubscriptionUsageRecordCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<SubscriptionMonthlyUsageRecord, ResourceCollection<SubscriptionMonthlyUsageRecord>>
{
}
