package com.microsoft.univstore.partnercentersdk.core.genericoperations;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="IEntityGetOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Groups operations for getting a single entity. The entity type.
 */
public interface IEntityDeleteOperations<T extends ResourceBase>
{
    /**
     * Deletes an entity.
     */
    void delete();
}