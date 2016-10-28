package com.microsoft.univstore.partnercentersdk.core.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SpendingBudget;

// -----------------------------------------------------------------------
// <copyright file="ICustomerUsageSpendingBudgetOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This interface defines the operations available on a customer's usage spending budget.
 */
public interface ICustomerUsageSpendingBudgetOperations
    extends IPartnerComponentString, IEntityGetOperations<SpendingBudget>,
    IEntityUpdateOperations<SpendingBudget>
{
}
