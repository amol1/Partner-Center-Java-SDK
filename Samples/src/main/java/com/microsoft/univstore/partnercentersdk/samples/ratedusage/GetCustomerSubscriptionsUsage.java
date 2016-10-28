package com.microsoft.univstore.partnercentersdk.samples.ratedusage;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionMonthlyUsageRecord;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetCustomerSubscriptionsUsage.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that retrieves the usage records for all the subscriptions owned by a customer.
 */
public class GetCustomerSubscriptionsUsage
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetCustomerSubscriptionsUsage} class.
     * 
     * @param context The scenario context.
     */
    public GetCustomerSubscriptionsUsage( IScenarioContext context )
    {
        super( "Get customer subscriptions usage", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerId =
            this.obtainCustomerId( "Enter the ID of the customer to retrieve his/her subscriptions usage" );
        this.getContext().getConsoleHelper().startProgress( "Retrieving customer subscriptions usage" );
        ResourceCollection<SubscriptionMonthlyUsageRecord> customerUsageRecords =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().getUsageRecords().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customerUsageRecords,
                                                          "Customer subscriptions usage records" );
    }

}
