package com.microsoft.univstore.partnercentersdk.models.partners;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;

// -----------------------------------------------------------------------
// <copyright file="PartnerProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Base partner profile
 */
@JsonIgnoreProperties( value = { "profileType" }, allowGetters = true )
public abstract class PartnerProfile
    extends ResourceBaseWithLinks
{
    /**
     * Gets the type of the profile.
     */
    public abstract PartnerProfileType getProfileType();

}
