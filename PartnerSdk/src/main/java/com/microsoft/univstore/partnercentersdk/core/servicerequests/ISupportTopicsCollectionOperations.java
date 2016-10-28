package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.SupportTopic;

// -----------------------------------------------------------------------
// <copyright file="ISupportTopicsCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of support topics. Support Topics operations are localizable.
 */
public interface ISupportTopicsCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<SupportTopic, ResourceCollection<SupportTopic>>
{
}
