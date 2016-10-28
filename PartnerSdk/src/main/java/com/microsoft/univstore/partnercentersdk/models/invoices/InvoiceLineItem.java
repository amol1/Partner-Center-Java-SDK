package com.microsoft.univstore.partnercentersdk.models.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="InvoiceLineItem.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents a line item on an invoice.
 */
@JsonIgnoreProperties({ "invoiceLineItemType", "billingProvider"})
public abstract class InvoiceLineItem
    extends ResourceBase
{
    /**
     * Gets the type of invoice line item
     */
    public abstract InvoiceLineItemType getInvoiceLineItemType();

    /**
     * Gets the billing provider
     */
    public abstract BillingProvider getBillingProvider();

}
