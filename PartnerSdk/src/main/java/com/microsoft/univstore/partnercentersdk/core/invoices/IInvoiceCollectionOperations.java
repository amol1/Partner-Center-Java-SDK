package com.microsoft.univstore.partnercentersdk.core.invoices;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.Summary;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;

// -----------------------------------------------------------------------
// <copyright file="IInvoiceCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the operations that can be done on Partner's invoices
 */
public interface IInvoiceCollectionOperations
    extends IPartnerComponentString, IEntityCollectionRetrievalOperations<Invoice, SeekBasedResourceCollection<Invoice>>
{
    /**
     * Gets a single invoice operations.
     * 
     * @param invoiceId The invoice id.
     * @return The invoice operations.
     */
    IInvoiceOperations byId( String invoiceId );

    /**
     * Retrieves the partner's current account balance.
     * 
     * @return The account balance..
     */
    Summary getInvoiceSummary();

}
