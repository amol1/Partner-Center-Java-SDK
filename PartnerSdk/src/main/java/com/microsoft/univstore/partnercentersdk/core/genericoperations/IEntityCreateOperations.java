package com.microsoft.univstore.partnercentersdk.core.genericoperations;

// -----------------------------------------------------------------------
// <copyright file="IEntityCreateOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

/**
 * Groups operations for creating a single entity. The entity type request.The entity type response.
 */
public interface IEntityCreateOperations<T, T1>
{
    /**
     * Creates a new entity.
     * 
     * @param newEntity The new entity information.
     * @return The entity information that was just created.
     */
    T1 create( T newEntity );

}
