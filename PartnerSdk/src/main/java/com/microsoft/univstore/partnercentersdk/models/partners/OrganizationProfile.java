package com.microsoft.univstore.partnercentersdk.models.partners;

import com.microsoft.univstore.partnercentersdk.models.Address;

// -----------------------------------------------------------------------
// <copyright file="OrganizationProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Partner's organization profile
 */
public class OrganizationProfile
    extends PartnerProfile
{
    /**
     * Initializes a new instance of the {@link #OrganizationProfile} class.
     */
    public OrganizationProfile()
    {
        this.setDefaultAddress( new Address() );
    }

    /**
     * Gets or sets the Id
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
     * Gets or sets the name of the company.
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
     * Gets or sets the partner identifier.
     */
    private String __PartnerId;

    public String getPartnerId()
    {
        return __PartnerId;
    }

    public void setPartnerId( String value )
    {
        __PartnerId = value;
    }

    /**
     * Gets or sets the default address.
     */
    private Address __DefaultAddress;

    public Address getDefaultAddress()
    {
        return __DefaultAddress;
    }

    public void setDefaultAddress( Address value )
    {
        __DefaultAddress = value;
    }

    /**
     * Gets or sets the tenant identifier.
     */
    private String __TenantId;

    public String getTenantId()
    {
        return __TenantId;
    }

    public void setTenantId( String value )
    {
        __TenantId = value;
    }

    /**
     * Gets or sets the domain.
     */
    private String __Domain;

    public String getDomain()
    {
        return __Domain;
    }

    public void setDomain( String value )
    {
        __Domain = value;
    }

    /**
     * Gets or sets the email
     */
    private String __Email;

    public String getEmail()
    {
        return __Email;
    }

    public void setEmail( String value )
    {
        __Email = value;
    }

    /**
     * Gets or sets the language
     */
    private String __Language;

    public String getLanguage()
    {
        return __Language;
    }

    public void setLanguage( String value )
    {
        __Language = value;
    }

    /**
     * Gets or sets the culture
     */
    private String __Culture;

    public String getCulture()
    {
        return __Culture;
    }

    public void setCulture( String value )
    {
        __Culture = value;
    }

    /**
     * Gets the type of the profile. The type of the profile.
     */
    public PartnerProfileType getProfileType()
    {
        return PartnerProfileType.ORGANIZATION_PROFILE;
    }

}
