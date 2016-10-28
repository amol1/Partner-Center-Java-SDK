package com.microsoft.univstore.partnercentersdk.samples.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetCustomerDetails.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets a single customer details.
 */
public class GetCustomerDetails
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetCustomerDetails} class.
     * 
     * @param context The scenario context.
     */
    public GetCustomerDetails( IScenarioContext context )
    {
        super( "Get a customer details", context );
    }

    /**
     * Executes the get customer details scenario.
     */
    @Override
    protected void runScenario()
    {
        String customerIdToRetrieve = this.obtainCustomerId( "Enter the ID of the customer to retrieve" );
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Retrieving customer" );
        Customer customerDetails = partnerOperations.getCustomers().byId( customerIdToRetrieve ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customerDetails, "Customer details" );        
    }

}
