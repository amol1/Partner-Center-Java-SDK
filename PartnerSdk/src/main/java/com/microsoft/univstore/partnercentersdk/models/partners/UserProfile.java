package com.microsoft.univstore.partnercentersdk.models.partners;

import com.microsoft.univstore.partnercentersdk.models.Profile;

// -----------------------------------------------------------------------
// <copyright file="UserProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Base Partner profile for both Company, Billing profiles
 */
public abstract class UserProfile
    extends Profile<UserProfile>
{
    /**
     * Gets the type of the profile.
     */
    public abstract UserProfileType getProfileType();

    /**
     * Gets or sets the culture.
     */
    private String __Culture = new String();

    public String getCulture()
    {
        return __Culture;
    }

    public void setCulture( String value )
    {
        __Culture = value;
    }

}
