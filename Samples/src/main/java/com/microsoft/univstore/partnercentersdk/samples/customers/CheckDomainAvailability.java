package com.microsoft.univstore.partnercentersdk.samples.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="CheckDomainAvailability.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that checks if a domain is still available for a customer or not.
 */
public class CheckDomainAvailability
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #CheckDomainAvailability} class.
     * 
     * @param context The scenario context.
     */
    public CheckDomainAvailability( IScenarioContext context )
    {
        super( "Check domain availability", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String domainPrefix =
            this.getContext().getConsoleHelper().readNonEmptyString( "Enter a domain prefix to check its availability",
                                                                     "The entered domain is empty" );
        this.getContext().getConsoleHelper().startProgress( "Checking" );
        boolean isDomainAvailable = partnerOperations.getValidations().checkDomainAvailability( domainPrefix );
        this.getContext().getConsoleHelper().stopProgress();
        if ( isDomainAvailable )
        {
            this.getContext().getConsoleHelper().success( "This domain prefix is available!" );
        }
        else
        {
            this.getContext().getConsoleHelper().warning( "This domain prefix is unavailable." );
        }
    }

}
