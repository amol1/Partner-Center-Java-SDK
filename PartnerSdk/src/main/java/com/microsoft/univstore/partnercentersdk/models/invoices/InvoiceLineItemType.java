package com.microsoft.univstore.partnercentersdk.models.invoices;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum InvoiceLineItemType
{
    // ----------------------------------------------------------------
    // <copyright file="InvoiceLineItemType.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * Lists invoice line item types. Default value.
     */
    @JsonProperty( "none" ) NONE("None" ),
    /**
     * Daily usage information for associated with an invoice. This information does not contain data about cost per
     * use.
     */
    @JsonProperty( "usage_line_items" ) USAGE_LINE_ITEMS("UsageLineItems" ),
    /**
     * Billing line items associated with an invoice. Contains information such as cost per use, tax charged, etc.
     */
    @JsonProperty( "billing_line_items" ) BILLING_LINE_ITEMS("BillingLineItems" );

    private String urlName;

    private InvoiceLineItemType( String urlName )
    {
        this.urlName = urlName;
    }

    public String getUrlName()
    {
        return this.urlName;
    }

}