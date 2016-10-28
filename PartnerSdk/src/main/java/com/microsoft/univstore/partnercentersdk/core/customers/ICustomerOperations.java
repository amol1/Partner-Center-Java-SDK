package com.microsoft.univstore.partnercentersdk.core.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.customers.profiles.ICustomerProfileCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityDeleteOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.managedservices.IManagedServiceCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.orders.IOrderCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.servicerequests.IServiceRequestCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.subscriptions.ISubscriptionCollectionOperations;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;

// -----------------------------------------------------------------------
// <copyright file="ICustomerOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Groups operations that can be performed on a single partner customer.
 */
public interface ICustomerOperations
    extends IPartnerComponentString, IEntityGetOperations<Customer>, IEntityDeleteOperations<Customer>
{
    /**
     * Gets the orders behavior for the customer.
     *
     * @return The customer orders.
     */
    IOrderCollectionOperations getOrders();

    /**
     * Obtains the profiles behavior for the customer.
     * 
     * @return The customer profiles.
     */
    ICustomerProfileCollectionOperations getProfiles();

    /**
     * Obtains the subscriptions behavior for the customer.
     * 
     * @return The customer subscriptions.
     */
    ISubscriptionCollectionOperations getSubscriptions();

    /**
     * Obtains the service requests behavior for the customer.
     */
    IServiceRequestCollectionOperations getServiceRequests();

    /**
     * Obtains the managed services behavior for the customer.
     */
    IManagedServiceCollectionOperations getManagedServices();

    /**
     * Obtains the customer usage summary behavior for the customer.
     */
    ICustomerUsageSummaryOperations getUsageSummary();

    /**
     * Obtains the usage spending budget behavior for the customer.
     */
    ICustomerUsageSpendingBudgetOperations getUsageBudget();

}
