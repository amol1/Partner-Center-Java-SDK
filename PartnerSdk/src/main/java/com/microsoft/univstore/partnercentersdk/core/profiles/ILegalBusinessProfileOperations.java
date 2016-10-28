package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.partners.LegalBusinessProfile;

// -----------------------------------------------------------------------
// <copyright file="ILegalBusinessProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates behavior of a legal business profile.
 */
public interface ILegalBusinessProfileOperations
    extends IPartnerComponentString, IEntityGetOperations<LegalBusinessProfile>,
    IEntityUpdateOperations<LegalBusinessProfile>
{
}
