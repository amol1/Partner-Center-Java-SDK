package com.microsoft.univstore.partnercentersdk.models.invoices;

import org.joda.time.DateTime;

import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;

// -----------------------------------------------------------------------
// <copyright file="Summary.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represent the current balance based on Partner's monthly bills.
 */
public class Summary
    extends ResourceBaseWithLinks
{
    /**
     * Gets or sets the balance amount. This is the total amount of unpaid bills.
     */
    private double __BalanceAmount;

    public double getBalanceAmount()
    {
        return __BalanceAmount;
    }

    public void setBalanceAmount( double value )
    {
        __BalanceAmount = value;
    }

    /**
     * Gets or sets the currency code for the balance amount.
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
     * Gets or sets the date the balance amount was last updated.
     */
    private DateTime __AccountingDate;

    public DateTime getAccountingDate()
    {
        return __AccountingDate;
    }

    public void setAccountingDate( DateTime value )
    {
    	__AccountingDate = value;
    }

    /**
     * Gets or sets the date the balance amount was last updated.
     */
    private DateTime __FirstInvoiceCreationDate;

    public DateTime getFirstInvoiceCreationDate()
    {
        return __FirstInvoiceCreationDate;
    }

    public void setFirstInvoiceCreationDate( DateTime value )
    {
        __FirstInvoiceCreationDate = value;
    }

}
