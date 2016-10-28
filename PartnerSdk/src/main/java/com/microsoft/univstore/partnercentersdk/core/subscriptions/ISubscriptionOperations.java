package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="ISubscriptionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This interface defines the operations available on a customer's subscription.
 */
public interface ISubscriptionOperations
    extends IPartnerComponent<Tuple<String, String>>, IEntityGetOperations<Subscription>,
    IEntityUpdateOperations<Subscription>
{
    /**
     * Gets the current subscription's add-ons operations.
     */
    ISubscriptionAddOnCollectionOperations getAddOns();

    /**
     * Gets the current subscription's upgrade operations.
     */
    ISubscriptionUpgradeCollectionOperations getUpgrades();

    /**
     * Gets the current subscription's resource usage records operations.
     */
    IResourceUsageRecordCollectionOperations getResourceUsageRecords();

    /**
     * Gets the current subscription's daily usage records operations.
     */
    ISubscriptionDailyUsageRecordCollectionOperations getDailyUsageRecords();

    /**
     * Gets the current subscription's usage summary operations.
     */
    ISubscriptionUsageSummaryOperations getUsageSummary();

}
