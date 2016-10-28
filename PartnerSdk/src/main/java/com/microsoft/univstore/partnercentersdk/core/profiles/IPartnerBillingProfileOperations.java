package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerBillingProfile;

// -----------------------------------------------------------------------
// <copyright file="IPartnerBillingProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates behavior of a partner billing profile.
 */
public interface IPartnerBillingProfileOperations
    extends IPartnerComponentString, IEntityGetOperations<PartnerBillingProfile>,
    IEntityUpdateOperations<PartnerBillingProfile>
{
}
