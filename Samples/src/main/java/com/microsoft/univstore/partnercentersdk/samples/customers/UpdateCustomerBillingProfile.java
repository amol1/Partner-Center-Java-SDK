package com.microsoft.univstore.partnercentersdk.samples.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="UpdateCustomerBillingProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that updates a customer's billing profile.
 */
public class UpdateCustomerBillingProfile
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #UpdateCustomerBillingProfile} class.
     * 
     * @param context The scenario context.
     */
    public UpdateCustomerBillingProfile( IScenarioContext context )
    {
        super( "Update customer billing profile", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        String customerId = this.obtainCustomerId();
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting customer billing profile" );
        CustomerBillingProfile billingProfile =
            partnerOperations.getCustomers().byId( customerId ).getProfiles().getBilling().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( billingProfile, "Customer billing profile" );
        this.getContext().getConsoleHelper().startProgress( "Updating the customer billing profile" );
        // append some A's to some of the customer's billing profile properties
        billingProfile.setFirstName( billingProfile.getFirstName() + "A" );
        billingProfile.setLastName( billingProfile.getLastName() + "A" );
        billingProfile.setCompanyName( billingProfile.getCompanyName() + "A" );
        // update the billing profile
        CustomerBillingProfile updatedBillingProfile =
            partnerOperations.getCustomers().byId( customerId ).getProfiles().getBilling().update( billingProfile );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( updatedBillingProfile, "Updated customer billing profile" );
    }

}
