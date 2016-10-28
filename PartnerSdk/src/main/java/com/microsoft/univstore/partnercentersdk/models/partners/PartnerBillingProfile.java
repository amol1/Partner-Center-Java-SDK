package com.microsoft.univstore.partnercentersdk.models.partners;

import com.microsoft.univstore.partnercentersdk.models.Address;
import com.microsoft.univstore.partnercentersdk.models.Contact;

// -----------------------------------------------------------------------
// <copyright file="PartnerBillingProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner billing profile.
 */
public class PartnerBillingProfile
    extends PartnerProfile
{
    /**
     * Initializes a new instance of the {@link #PartnerBillingProfile} class.
     */
    public PartnerBillingProfile()
    {
        this.setAddress( new Address() );
        this.setPrimaryContact( new Contact() );
    }

    /**
     * Gets or sets the billing company name.
     */
    private String __CompanyName;

    public String getCompanyName()
    {
        return __CompanyName;
    }

    public void setCompanyName( String value )
    {
        __CompanyName = value;
    }

    /**
     * Gets or sets the billing address.
     */
    private Address __Address;

    public Address getAddress()
    {
        return __Address;
    }

    public void setAddress( Address value )
    {
        __Address = value;
    }

    /**
     * Gets or sets the billing primary contact.
     */
    private Contact __PrimaryContact;

    public Contact getPrimaryContact()
    {
        return __PrimaryContact;
    }

    public void setPrimaryContact( Contact value )
    {
        __PrimaryContact = value;
    }

    /**
     * Gets or sets the purchase order number.
     */
    private String __PurchaseOrderNumber;

    public String getPurchaseOrderNumber()
    {
        return __PurchaseOrderNumber;
    }

    public void setPurchaseOrderNumber( String value )
    {
        __PurchaseOrderNumber = value;
    }

    /**
     * Gets or sets the tax Id.
     */
    private String __TaxId;

    public String getTaxId()
    {
        return __TaxId;
    }

    public void setTaxId( String value )
    {
        __TaxId = value;
    }

    /**
     * Gets or sets the billing currency.
     */
    private String __BillingCurrency;

    public String getBillingCurrency()
    {
        return __BillingCurrency;
    }

    public void setBillingCurrency( String value )
    {
        __BillingCurrency = value;
    }

    /**
     * Gets the profile type.
     */
    public PartnerProfileType getProfileType()
    {
        return PartnerProfileType.PARTNER_BILLING_PROFILE;
    }

}
