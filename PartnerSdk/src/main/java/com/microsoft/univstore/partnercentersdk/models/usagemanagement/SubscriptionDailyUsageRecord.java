package com.microsoft.univstore.partnercentersdk.models.usagemanagement;

import org.joda.time.DateTime;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionDailyUsageRecord.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class defines the daily usage record of a specific subscription.
 */
public class SubscriptionDailyUsageRecord
    extends UsageRecordBase
{
    /**
     * Gets or sets the usage date.
     */
    private DateTime __DateUsed;

    public DateTime getDateUsed()
    {
        return __DateUsed;
    }

    public void setDateUsed( DateTime value )
    {
        __DateUsed = value;
    }

}
