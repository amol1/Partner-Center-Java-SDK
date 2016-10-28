package com.microsoft.univstore.partnercentersdk.samples.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.ManagedService;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetCustomerManagedServices.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets a customer list of managed services.
 */
public class GetCustomerManagedServices
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetCustomerManagedServices} class.
     * 
     * @param context The scenario context.
     */
    public GetCustomerManagedServices( IScenarioContext context )
    {
        super( "Get customer managed services", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        String customerId = this.obtainCustomerId();
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting the customer's managed services" );
        ResourceCollection<ManagedService> managedServices =
            partnerOperations.getCustomers().byId( customerId ).getManagedServices().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( managedServices, "Customer managed services" );
    }

}