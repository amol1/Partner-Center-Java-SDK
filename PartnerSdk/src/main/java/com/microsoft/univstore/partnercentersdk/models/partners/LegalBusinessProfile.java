package com.microsoft.univstore.partnercentersdk.models.partners;

import com.microsoft.univstore.partnercentersdk.models.Address;
import com.microsoft.univstore.partnercentersdk.models.Contact;

// -----------------------------------------------------------------------
// <copyright file="LegalBusinessProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The legal business profile.
 */
public class LegalBusinessProfile
    extends PartnerProfile
{
    /**
     * Initializes a new instance of the {@link #LegalBusinessProfile} class.
     */
    public LegalBusinessProfile()
    {
        // this.setAddress(new Address());
        // this.setPrimaryContact(new Contact());
        // this.setCompanyApproverAddress(new Address());
    }

    /**
     * Gets or sets the legal company name.
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
     * Gets or sets the address.
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
     * Gets or sets the primary contact.
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
     * Gets or sets the company approver address.
     */
    private Address __CompanyApproverAddress;

    public Address getCompanyApproverAddress()
    {
        return __CompanyApproverAddress;
    }

    public void setCompanyApproverAddress( Address value )
    {
        __CompanyApproverAddress = value;
    }

    /**
     * Gets or sets the company approver email.
     */
    private String __CompanyApproverEmail;

    public String getCompanyApproverEmail()
    {
        return __CompanyApproverEmail;
    }

    public void setCompanyApproverEmail( String value )
    {
        __CompanyApproverEmail = value;
    }

    /**
     * Gets the profile type.
     */
    public PartnerProfileType getProfileType()
    {
        return PartnerProfileType.LEGAL_BUSINESS_PROFILE;
    }

}
