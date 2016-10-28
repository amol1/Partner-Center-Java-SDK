package com.microsoft.univstore.partnercentersdk.models.usagemanagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.SubscriptionStatus;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionMonthlyUsageRecord.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The class defines the monthly usage record of a subscription.
 */
@JsonIgnoreProperties( { "offerId", "lastModifiedDate" } )
public class SubscriptionMonthlyUsageRecord
    extends UsageRecordBase
{
    /**
     * Gets or sets the resource unique identifier. In the context of CustomerMonthlyUsageRecord this id is the customer
     * id.
     */
    private String __ResourceId;

    public String getResourceId()
    {
        return __ResourceId;
    }

    public void setResourceId( String value )
    {
        __ResourceId = value;
    }

    /**
     * Gets or sets the name of the resource. In the context of CustomerMonthlyUsageRecord this name is the customer
     * name.
     */
    private String __ResourceName;

    public String getResourceName()
    {
        return __ResourceName;
    }

    public void setResourceName( String value )
    {
        __ResourceName = value;
    }

    /**
     * Gets or sets the status of the subscription.
     */
    private SubscriptionStatus __Status = SubscriptionStatus.NONE;

    public SubscriptionStatus getStatus()
    {
        return __Status;
    }

    public void setStatus( SubscriptionStatus value )
    {
        __Status = value;
    }

    /**
     * Gets or sets the partner on record.
     */
    private String __PartnerOnRecord;

    public String getPartnerOnRecord()
    {
        return __PartnerOnRecord;
    }

    public void setPartnerOnRecord( String value )
    {
        __PartnerOnRecord = value;
    }

}
