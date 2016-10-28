package com.microsoft.univstore.partnercentersdk.samples.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="UpdateSubscription.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that updates an existing customer subscription.
 */
public class UpdateSubscription
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #UpdateSubscription} class.
     * 
     * @param context The scenario context.
     */
    public UpdateSubscription( IScenarioContext context )
    {
        super( "Update existing customer subscription", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerId = this.obtainCustomerId();
        String subscriptionId = this.obtainSubscriptionId( customerId, "Enter the ID of the subscription to update" );
        this.getContext().getConsoleHelper().startProgress( "Retrieving customer subscription" );
        Subscription existingSubscription =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().byId( subscriptionId ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( existingSubscription, "Existing subscription" );
        this.getContext().getConsoleHelper().startProgress( "Incrementing subscription quantity" );
        existingSubscription.setQuantity( existingSubscription.getQuantity() + 1 );
        Subscription updatedSubscription =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().byId( subscriptionId ).update( existingSubscription );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( updatedSubscription, "Updated subscription" );
    }

}
