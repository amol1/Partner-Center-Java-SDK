package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;

// -----------------------------------------------------------------------
// <copyright file="IPartnerProfileCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of a partner's profiles.
 */
public interface IPartnerProfileCollectionOperations
    extends IPartnerComponentString
{
    /**
     * Gets the operations available for the legal business profile.
     */
    ILegalBusinessProfileOperations getLegalBusinessProfile();

    /**
     * Gets the operations available for the partner network profile.
     */
    IPartnerNetworkProfileOperations getPartnerNetworkProfile();

    /**
     * Gets the operations available for the partner support profile.
     */
    ISupportProfileOperations getSupportProfile();

    /**
     * Gets the operations available for the organization profile.
     */
    IOrganizationProfileOperations getOrganizationProfile();

    /**
     * Gets the operations available for the partner billing profile.
     */
    IPartnerBillingProfileOperations getPartnerBillingProfile();

    /**
     * Gets the operations available for the partner profile types.
     */
    IPartnerProfileTypeCollectionOperations getTypes();

}
