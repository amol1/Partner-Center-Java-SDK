package com.microsoft.univstore.partnercentersdk.samples.invoice;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceDetail;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetInvoice.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets a single partner invoice.
 */
public class GetInvoice
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetInvoice} class.
     * 
     * @param context The scenario context.
     */
    public GetInvoice( IScenarioContext context )
    {
        super( "Get partner's invoice details", context );
    }

    /**
     * executes the get invoice scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String invoiceId = this.getContext().getConfiguration().getScenarioSettings().get( "DefaultInvoiceId" );
        if ( StringHelper.isNullOrWhiteSpace( invoiceId ) )
        {
            // prompt the user the enter the invoice ID
            invoiceId =
                this.getContext().getConsoleHelper().readNonEmptyString( "Please enter the invoice ID to retrieve ",
                                                                         "The invoice ID can't be empty" );
        }
        else
        {
            ConsoleHelper.getInstance().warning( MessageFormat.format( "Found Invoice ID: {0} in configuration.",
                                                                       invoiceId ) );
        }
        this.getContext().getConsoleHelper().startProgress( "Retrieving invoice" );
        // Retrieving invoice
        Invoice invoice = partnerOperations.getInvoices().byId( invoiceId ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( invoice, "Invoice details" );
        // Retrieving invoice line items
        if ( invoice.getInvoiceDetails() != null )
        {
            for ( InvoiceDetail invoiceDetail : invoice.getInvoiceDetails() )
            {
                this.getContext().getConsoleHelper().writeObject( invoiceDetail, "Invoice Line Items" );
            }
        }

    }

}
