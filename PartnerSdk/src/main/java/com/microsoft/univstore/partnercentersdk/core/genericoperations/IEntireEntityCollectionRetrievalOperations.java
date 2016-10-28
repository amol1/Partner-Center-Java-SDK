package com.microsoft.univstore.partnercentersdk.core.genericoperations;

import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;

// -----------------------------------------------------------------------
// <copyright file="IEntireEntityCollectionRetrievalOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A generic interface which represents operations for getting an entire collection of entities. The entity type.The
 * entity collection type.
 */
public interface IEntireEntityCollectionRetrievalOperations<T, TResourceCollection extends ResourceCollection<T>>
{
    /**
     * Retrieves all entities.
     * 
     * @return The entities.
     */
    TResourceCollection get();

}
