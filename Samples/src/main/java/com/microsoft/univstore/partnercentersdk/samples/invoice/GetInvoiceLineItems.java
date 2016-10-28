package com.microsoft.univstore.partnercentersdk.samples.invoice;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.core.invoices.IInvoiceOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceDetail;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetInvoiceLineItems.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets an invoice's line items.
 */
public class GetInvoiceLineItems
    extends BasePartnerScenario
{
    /**
     * The invoice page size.
     */
    private final int invoicePageSize;

    /**
     * Initializes a new instance of the {@link #GetInvoiceLineItems} class.
     * 
     * @param context The scenario context.
     * @param invoicePageSize The number of invoice line items to return per page.
     */
    public GetInvoiceLineItems( IScenarioContext context, int invoicePageSize )
    {
        super( "Get an invoice's line items", context );
        this.invoicePageSize = invoicePageSize;
    }

    /**
     * executes the get invoice line items scenario.
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
                this.getContext().getConsoleHelper().readNonEmptyString( "Please enter the ID of the invoice to retrieve ",
                                                                         "The ID can't be empty" );
        }
        else
        {
            ConsoleHelper.getInstance().warning( MessageFormat.format( "Found Invoice ID: {0} in configuration.",
                                                                       invoiceId ) );
        }
        this.getContext().getConsoleHelper().startProgress( "Retrieving Invoice Line Items" );
        // Retrieve the invoice
        IInvoiceOperations invoiceOperations = partnerOperations.getInvoices().byId( invoiceId );
        Invoice invoice = invoiceOperations.get();
        this.getContext().getConsoleHelper().stopProgress();
        if ( ( invoice.getInvoiceDetails() == null ) || ( !invoice.getInvoiceDetails().iterator().hasNext() ) )
        {
            this.getContext().getConsoleHelper().warning( MessageFormat.format( "Invoice {0} does not have any invoice line items",
                                                                                invoice.getId() ) );
        }
        else
        {
            for ( InvoiceDetail invoiceDetail : invoice.getInvoiceDetails() )
            {
                this.getContext().getConsoleHelper().startProgress( MessageFormat.format( "Getting invoice line item for product {0} and line item type {1}",
                                                                                          invoiceDetail.getBillingProvider(),
                                                                                          invoiceDetail.getInvoiceLineItemType() ) );
                // Get the invoice line items
                SeekBasedResourceCollection<InvoiceLineItem> invoiceLineItemsCollection = invoicePageSize == 0
                                ? invoiceOperations.getInvoiceLineItems( invoiceDetail.getBillingProvider(),
                                                                         invoiceDetail.getInvoiceLineItemType() )
                                : invoiceOperations.getInvoiceLineItems( invoiceDetail.getBillingProvider(),
                                                                         invoiceDetail.getInvoiceLineItemType(), 0,
                                                                         invoicePageSize );
                IResourceCollectionEnumerator<SeekBasedResourceCollection<InvoiceLineItem>> invoiceLineItemEnumerator =
                    partnerOperations.getEnumerators().getInvoiceLineItems().create( invoiceLineItemsCollection );
                this.getContext().getConsoleHelper().stopProgress();
                int pageNumber = 1;
                while ( invoiceLineItemEnumerator.hasValue() )
                {
                    this.getContext().getConsoleHelper().writeObject( invoiceLineItemEnumerator.getCurrent(),
                                                                      MessageFormat.format( "Invoice Line Item Page: {0}",
                                                                                            pageNumber++ ) );
                    ConsoleHelper.getInstance().warning( "\nPress Enter to retrieve the next invoice line items page" );
                    ConsoleHelper.getInstance().getScanner().nextLine();
                    this.getContext().getConsoleHelper().startProgress( "Getting next invoice line items page" );
                    // Get the next list of invoice line items
                    invoiceLineItemEnumerator.next();
                    this.getContext().getConsoleHelper().stopProgress();
                }
            }
        }
    }

}
