package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.partners.OrganizationProfile;

// -----------------------------------------------------------------------
// <copyright file="IOrganizationProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates behavior of a organization profile.
 */
public interface IOrganizationProfileOperations
    extends IPartnerComponentString, IEntityGetOperations<OrganizationProfile>,
    IEntityUpdateOperations<OrganizationProfile>
{
    /**
     * Retrieves the partner's organization profile. This operation is currently only supported for user based
     * credentials.
     * 
     * @return The organization profile.
     */
    OrganizationProfile get();

    /**
     * Updates the partner's organization profile. This operation is currently only supported for user based
     * credentials.
     * 
     * @param entity The organization profile.
     * @return The updated organization profile.
     */
    OrganizationProfile update( OrganizationProfile entity );

}
