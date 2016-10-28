package com.microsoft.univstore.partnercentersdk.samples.ratedusage;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerUsageSummary;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetCustomerUsageSummary.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that retrieves a single customer usage summary for usage based services.
 */
public class GetCustomerUsageSummary
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetCustomerUsageSummary} class.
     * 
     * @param context The scenario context.
     */
    public GetCustomerUsageSummary( IScenarioContext context )
    {
        super( "Get customer usage summary", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerId = this.obtainCustomerId( "Enter the ID of the customer to retrieve his/her usage summary" );
        this.getContext().getConsoleHelper().startProgress( "Retrieving customer usage summary" );
        CustomerUsageSummary customerUsageSummary =
            partnerOperations.getCustomers().byId( customerId ).getUsageSummary().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customerUsageSummary, "Customer usage summary" );
    }

}
