package com.microsoft.univstore.partnercentersdk.core.genericoperations;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;

// -----------------------------------------------------------------------
// <copyright file="IPagedEntityCollectionRetrievalOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A generic interface which represents paged entity retrieval operations. The entity type.The entity collection type.
 */
public interface IPagedEntityCollectionRetrievalOperations<T extends ResourceBase, TResourceCollection extends ResourceCollection<T>>
{
    /**
     * Retrieves a subset of entities.
     *
     * @param offset The starting index.
     * @param size The maximum number of entities to return.
     * @return The requested entities subset.
     */
    TResourceCollection get( int offset, int size );

}
