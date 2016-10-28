package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionUsageSummary;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="ISubscriptionUsageSummaryOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This interface defines the operations available on a customer's subscription usage summary.
 */
public interface ISubscriptionUsageSummaryOperations
    extends IPartnerComponent<Tuple<String, String>>, IEntityGetOperations<SubscriptionUsageSummary>
{
}
