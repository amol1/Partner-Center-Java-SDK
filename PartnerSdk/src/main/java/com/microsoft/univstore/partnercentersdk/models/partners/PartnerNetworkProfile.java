package com.microsoft.univstore.partnercentersdk.models.partners;

// -----------------------------------------------------------------------
// <copyright file="PartnerNetworkProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Microsoft Partner Network profile of a partner
 */
public class PartnerNetworkProfile
    extends PartnerProfile
{
    /**
     * Gets or sets the organization name.
     */
    private String __PartnerName = new String();

    public String getPartnerName()
    {
        return __PartnerName;
    }

    public void setPartnerName( String value )
    {
        __PartnerName = value;
    }

    /**
     * Gets or sets the Microsoft Partner Network Id
     */
    private String __MpnId = new String();

    public String getMpnId()
    {
        return __MpnId;
    }

    public void setMpnId( String value )
    {
        __MpnId = value;
    }

    /**
     * Returns the partner profile type
     */
    public PartnerProfileType getProfileType()
    {
        return PartnerProfileType.PARTNER_NETWORK_PROFILE;
    }

}
