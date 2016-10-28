package com.microsoft.univstore.partnercentersdk.models.usagemanagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// -----------------------------------------------------------------------
// <copyright file="PartnerUsageSummary.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class defines the usage summary of a partner for all its customers with an Azure subscription
 */
@JsonIgnoreProperties( { "customersWithUsageBasedSubscription", "lastModifiedDate" } )
public class PartnerUsageSummary
    extends UsageSummaryBase
{
    /**
     * Gets or sets the list of email addresses for notifications.
     */
    private Iterable<String> __EmailNotification;

    public Iterable<String> getEmailNotification()
    {
        return __EmailNotification;
    }

    public void setEmailNotification( Iterable<String> value )
    {
        __EmailNotification = value;
    }

    /**
     * Gets or sets the number of customers that are over budget.
     */
    private long __CustomersOverBudget;

    public long getCustomersOverBudget()
    {
        return __CustomersOverBudget;
    }

    public void setCustomersOverBudget( long value )
    {
        __CustomersOverBudget = value;
    }

    /**
     * Gets or sets the number of customers that are close to going over budget.
     */
    private long __CustomersTrendingOver;

    public long getCustomersTrendingOver()
    {
        return __CustomersTrendingOver;
    }

    public void setCustomersTrendingOver( long value )
    {
        __CustomersTrendingOver = value;
    }

}
