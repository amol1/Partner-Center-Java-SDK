package com.microsoft.univstore.partnercentersdk.samples.invoice;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.invoices.Summary;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetInvoiceSummary.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets the account balance for a partner.
 */
public class GetInvoiceSummary
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetInvoiceSummary} class.
     * 
     * @param context The scenario context.
     */
    public GetInvoiceSummary( IScenarioContext context )
    {
        super( "Get invoice summary", context );
    }

    /**
     * executes the get invoice summary scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting Invoice Summary" );
        // Getting the account balance
        Summary invoiceSummary = partnerOperations.getInvoices().getInvoiceSummary();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( invoiceSummary, "Invoice Summary" );
    }

}
