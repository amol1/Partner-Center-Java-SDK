package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerProfileType;

// -----------------------------------------------------------------------
// <copyright file="IPartnerProfileTypeCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates behavior of profile types.
 */
public interface IPartnerProfileTypeCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<PartnerProfileType, ResourceCollection<PartnerProfileType>>
{
    /**
     * Gets all the applicable profile types.
     * 
     * @return All the applicable profile types.
     */
    ResourceCollection<PartnerProfileType> get();
}
