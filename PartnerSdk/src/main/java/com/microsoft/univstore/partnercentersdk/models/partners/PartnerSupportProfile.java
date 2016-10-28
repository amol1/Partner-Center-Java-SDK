package com.microsoft.univstore.partnercentersdk.models.partners;

// -----------------------------------------------------------------------
// <copyright file="PartnerSupportProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Partner Support Profile
 */
public class PartnerSupportProfile
    extends PartnerProfile
{
    /**
     * Gets or sets the email.
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
     * Gets or sets the telephone.
     */
    private String __Telephone;

    public String getTelephone()
    {
        return __Telephone;
    }

    public void setTelephone( String value )
    {
        __Telephone = value;
    }

    /**
     * Gets or sets the website.
     */
    private String __Website;

    public String getWebsite()
    {
        return __Website;
    }

    public void setWebsite( String value )
    {
        __Website = value;
    }

    /**
     * Gets the partner profile type
     */
    public PartnerProfileType getProfileType()
    {
        return PartnerProfileType.SUPPORT_PROFILE;
    }

}
