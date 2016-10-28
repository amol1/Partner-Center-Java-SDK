package com.microsoft.univstore.partnercentersdk.models.invoices;

import java.net.URI;

import org.joda.time.DateTime;

import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;

// -----------------------------------------------------------------------
// <copyright file="Invoice.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents a monthly billing statement issued to a partner
 */
public class Invoice
    extends ResourceBaseWithLinks
{
    /**
     * Gets or sets the invoice unique identifier
     */
    private String __Id;

    public String getId()
    {
        return __Id;
    }

    public void setId( String value )
    {
        __Id = value;
    }

    /**
     * Gets or sets the date the invoice was generated.
     */
    private DateTime __InvoiceDate;

    public DateTime getInvoiceDate()
    {
        return __InvoiceDate;
    }

    public void setInvoiceDate( DateTime value )
    {
        __InvoiceDate = value;
    }

    /**
     * Gets or sets the total charges in this invoice. Total charges includes the transactions charges and any
     * adjustments
     */
    private double __TotalCharges;

    public double getTotalCharges()
    {
        return __TotalCharges;
    }

    public void setTotalCharges( double value )
    {
        __TotalCharges = value;
    }

    /**
     * Gets or sets the amount paid by the partner. Paid amount is negative if a payment is received.
     */
    private double __PaidAmount;

    public double getPaidAmount()
    {
        return __PaidAmount;
    }

    public void setPaidAmount( double value )
    {
        __PaidAmount = value;
    }

    /**
     * Gets or sets the currency used for all invoice item amounts and totals.
     */
    private String __CurrencyCode;

    public String getCurrencyCode()
    {
        return __CurrencyCode;
    }

    public void setCurrencyCode( String value )
    {
        __CurrencyCode = value;
    }

    /**
     * Gets or sets the link to download the invoice PDF document This value is not returned as part of the search
     * results. It will only get populated if invoice is accessed by Id. This link auto expires in 30 minutes
     */
    private URI __PdfDownloadLink;

    public URI getPdfDownloadLink()
    {
        return __PdfDownloadLink;
    }

    public void setPdfDownloadLink( URI value )
    {
        __PdfDownloadLink = value;
    }

    /**
     * Gets or sets the invoice details
     */
    private Iterable<InvoiceDetail> __InvoiceDetails;

    public Iterable<InvoiceDetail> getInvoiceDetails()
    {
        return __InvoiceDetails;
    }

    public void setInvoiceDetails( Iterable<InvoiceDetail> value )
    {
        __InvoiceDetails = value;
    }

}
