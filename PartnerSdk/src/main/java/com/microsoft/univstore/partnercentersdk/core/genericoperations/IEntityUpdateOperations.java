package com.microsoft.univstore.partnercentersdk.core.genericoperations;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="IEntityUpdateOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Groups operations for updating a single entity. The entity type.
 */
public interface IEntityUpdateOperations<T extends ResourceBase>
{
    /**
     * Updates an entity.
     * 
     * @param entity The entity information.
     * @return The updated entity.
     */
    T update( T entity );
}
