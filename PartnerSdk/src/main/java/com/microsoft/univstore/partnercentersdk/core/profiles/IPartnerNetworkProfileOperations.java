package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerNetworkProfile;

// -----------------------------------------------------------------------
// <copyright file="IPartnerNetworkProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Operations for PartnerNetworkProfile
 */
public interface IPartnerNetworkProfileOperations
    extends IPartnerComponentString, IEntityGetOperations<PartnerNetworkProfile>
{
    /**
     * Retrieves a PartnerNetworkProfile by MPN Id.
     * 
     * @param mpnId The MPN id.
     * @return The partner network profile.
     */
    PartnerNetworkProfile get( String mpnId );

}
