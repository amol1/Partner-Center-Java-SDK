package com.microsoft.univstore.partnercentersdk.core.genericoperations;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;

// -----------------------------------------------------------------------
// <copyright file="IEntityCollectionRetrievalOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Groups all operations related to retrieving a collection of entities. The entity type.The entity collection type.
 */
public interface IEntityCollectionRetrievalOperations<T extends ResourceBase, TResourceCollection extends ResourceCollection<T>>
    extends IEntireEntityCollectionRetrievalOperations<T, TResourceCollection>,
    IPagedEntityCollectionRetrievalOperations<T, TResourceCollection>
{
}
