package com.microsoft.univstore.partnercentersdk.samples.customers;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="DeleteCustomerFromTipAccount.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Deletes a customer from a testing in production account.
 */
public class DeleteCustomerFromTipAccount
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #DeleteCustomerFromTipAccount} class.
     * 
     * @param context The scenario context.
     */
    public DeleteCustomerFromTipAccount( IScenarioContext context )
    {
        super( "Delete customer from TIP account", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        String customerIdToDelete =
            this.getContext().getConfiguration().getScenarioSettings().get( "CustomerIdToDelete" );
        if ( StringHelper.isNullOrWhiteSpace( customerIdToDelete ) )
        {
            // prompt the user the enter the customer ID
            customerIdToDelete =
                this.getContext().getConsoleHelper().readNonEmptyString( "Enter the ID of the customer to delete",
                                                                         "The customer ID can't be empty" );
        }
        else
        {
            System.out.println( MessageFormat.format( "Found customer ID: {0} in configuration.",
                                                      customerIdToDelete ) );
        }
        IPartnerOperations partnerOperations = this.getContext().getAppPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Deleting customer" );
        partnerOperations.getCustomers().byId( customerIdToDelete ).delete();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().success( "Customer successfully deleted" );
    }

}
