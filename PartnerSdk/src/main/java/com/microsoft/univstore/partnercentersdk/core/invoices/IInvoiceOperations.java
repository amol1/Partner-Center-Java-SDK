package com.microsoft.univstore.partnercentersdk.core.invoices;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.BillingProvider;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItemType;

// -----------------------------------------------------------------------
// <copyright file="IInvoiceOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents all the operations that can be done on an invoice
 */
public interface IInvoiceOperations
    extends IPartnerComponentString, IEntityGetOperations<Invoice>
{
    /**
     * Retrieves the invoice. This operation is currently only supported for user based credentials.
     * 
     * @return The invoice.
     */
    Invoice get();

    /**
     * Retrieves invoice line items for a specific billing provider and invoice line item type
     * 
     * @param billingProvider The provider of billing information.
     * @param invoiceLineItemType The type of invoice line item.
     * @return The collection of invoice line items.
     */
    SeekBasedResourceCollection<InvoiceLineItem> getInvoiceLineItems( BillingProvider billingProvider,
                                                                  InvoiceLineItemType invoiceLineItemType );

    /**
     * Retrieves a subset of invoice line items for a specific billing provider and invoice line item type
     * 
     * @param billingProvider The provider of billing information,
     * @param invoiceLineItemType The type of invoice line item.
     * @param size The maximum number of invoice line items to return.
     * @param offset The page offset.
     * @return The subset of invoice line items.
     */
    SeekBasedResourceCollection<InvoiceLineItem> getInvoiceLineItems( BillingProvider billingProvider,
                                                                  InvoiceLineItemType invoiceLineItemType, int size,
                                                                  int offset );

}
