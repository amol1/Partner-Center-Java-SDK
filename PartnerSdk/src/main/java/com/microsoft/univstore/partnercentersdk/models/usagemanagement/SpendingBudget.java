package com.microsoft.univstore.partnercentersdk.models.usagemanagement;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="SpendingBudget.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The spending budget allocated to the customer by the partner.
 */
public class SpendingBudget
    extends ResourceBase
{
    /**
     * Gets or sets the usage spending budget.
     */
    private Double __Amount;

    public Double getAmount()
    {
        return __Amount;
    }

    public void setAmount( Double value )
    {
        __Amount = value;
    }

}
