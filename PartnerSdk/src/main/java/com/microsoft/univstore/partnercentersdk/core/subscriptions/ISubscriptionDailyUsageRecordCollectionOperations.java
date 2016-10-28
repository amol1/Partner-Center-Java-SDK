package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionDailyUsageRecord;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// <copyright file="ISubscriptionDailyUsageRecordCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines the behavior for a subscription's daily usage records.
 */
public interface ISubscriptionDailyUsageRecordCollectionOperations
    extends IPartnerComponent<Tuple<String, String>>,
    IEntireEntityCollectionRetrievalOperations<SubscriptionDailyUsageRecord, ResourceCollection<SubscriptionDailyUsageRecord>>
{
}
