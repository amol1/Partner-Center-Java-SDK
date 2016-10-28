package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerSupportProfile;

// -----------------------------------------------------------------------
// <copyright file="ISupportProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates behavior of a partner support profile.
 */
public interface ISupportProfileOperations
    extends IPartnerComponentString, IEntityGetOperations<PartnerSupportProfile>,
    IEntityUpdateOperations<PartnerSupportProfile>
{
    /**
     * Retrieves the partner's support profile. This operation is currently only supported for user based credentials.
     * 
     * @return The partner's support profile.
     */
    PartnerSupportProfile get();

    /**
     * Updates the partner's support profile. This operation is currently only supported for user based credentials.
     * 
     * @param entity The support profile.
     * @return The updated support profile.
     */
    PartnerSupportProfile update( PartnerSupportProfile entity );

}
