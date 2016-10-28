package com.microsoft.univstore.partnercentersdk.models.usagemanagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// -----------------------------------------------------------------------
// <copyright file="CustomerUsageSummary.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class defines the usage summary for a specific customer.
 */
@JsonIgnoreProperties( "lastModifiedDate" )
public class CustomerUsageSummary
    extends UsageSummaryBase
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
     * Gets or sets the spending budget allocated to a customer.
     */
    private SpendingBudget __Budget;

    public SpendingBudget getBudget()
    {
        return __Budget;
    }

    public void setBudget( SpendingBudget value )
    {
    	__Budget = value;
    }

    /**
     * Gets or sets the spending budget allocated to a customer.
     */
    private SpendingBudget __CustomerSpendingBudget;

    public SpendingBudget getCustomerSpendingBudget()
    {
        return __CustomerSpendingBudget;
    }

    public void setCustomerSpendingBudget( SpendingBudget value )
    {
    	__CustomerSpendingBudget = value;
    }

}
