package com.microsoft.univstore.partnercentersdk.samples.ratedusage;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.AzureResourceMonthlyUsageRecord;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetSubscriptionResourceUsage.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that retrieves a single subscription's resource usage records.
 */
public class GetSubscriptionResourceUsage
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetSubscriptionResourceUsage} class.
     * 
     * @param context The scenario context.
     */
    public GetSubscriptionResourceUsage( IScenarioContext context )
    {
        super( "Get subscription resource usage", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerId = this.obtainCustomerId( "Enter the ID of the customer who owns the subscription" );
        String subscriptionId = this.obtainSubscriptionId( customerId, "Enter the subscription ID" );
        this.getContext().getConsoleHelper().startProgress( "Retrieving customer orders" );
        ResourceCollection<AzureResourceMonthlyUsageRecord> usageRecords =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().byId( subscriptionId ).getResourceUsageRecords().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( usageRecords, "Subscription resource usage records" );
    }

}
