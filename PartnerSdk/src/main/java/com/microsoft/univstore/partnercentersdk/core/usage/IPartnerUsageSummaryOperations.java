package com.microsoft.univstore.partnercentersdk.core.usage;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.PartnerUsageSummary;

// -----------------------------------------------------------------------
// <copyright file="IPartnerUsageSummaryOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This interface defines the operations available on a partner's usage summary.
 */
public interface IPartnerUsageSummaryOperations
    extends IPartnerComponentString, IEntityGetOperations<PartnerUsageSummary>
{
}
