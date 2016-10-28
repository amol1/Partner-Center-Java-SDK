package com.microsoft.univstore.partnercentersdk.samples.invoice;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetPagedInvoices.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets paged invoices for partners.
 */
public class GetPagedInvoices
    extends BasePartnerScenario
{
    /**
     * The invoice page size.
     */
    private final int invoicePageSize;

    /**
     * Initializes a new instance of the {@link #GetPagedInvoices} class.
     * 
     * @param context The scenario context.
     * @param invoicePageSize The number of invoices to return per page.
     */
    public GetPagedInvoices( IScenarioContext context, int invoicePageSize )
    {
        super( "Get paged invoices", context );
        this.invoicePageSize = invoicePageSize;
    }

    /**
     * executes the get paged invoices scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Querying invoices" );
        int pageNumber = 1;
        // Query the invoices, get the first page if a page size was set, otherwise get all invoices
        SeekBasedResourceCollection<Invoice> invoicesPage =
            ( this.invoicePageSize <= 0 ) ? partnerOperations.getInvoices().get()
                            : partnerOperations.getInvoices().get( 0, this.invoicePageSize );
        IResourceCollectionEnumerator<SeekBasedResourceCollection<Invoice>> invoiceEnumerator =
            partnerOperations.getEnumerators().getInvoices().create( invoicesPage );
        this.getContext().getConsoleHelper().stopProgress();
        while ( invoiceEnumerator.hasValue() )
        {
            this.getContext().getConsoleHelper().writeObject( invoiceEnumerator.getCurrent(),
                                                              MessageFormat.format( "Invoices Page: {0}",
                                                                                    pageNumber++ ) );
            ConsoleHelper.getInstance().warning( "\nPress Enter to retrieve the next invoice page" );
            ConsoleHelper.getInstance().getScanner().nextLine();
            this.getContext().getConsoleHelper().startProgress( "Getting next invoice page" );
            // Get the next page of invoices
            invoiceEnumerator.next();
            this.getContext().getConsoleHelper().stopProgress();
        }
    }

}
