package com.microsoft.univstore.partnercentersdk.core.factory;

import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;

// -----------------------------------------------------------------------
// <copyright file="IResourceCollectionEnumeratorFactory.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Creates resource collection enumerators which can enumerate through resource collections. The collection type.
 */
public interface IResourceCollectionEnumeratorFactory<T extends ResourceBaseWithLinks>
{
    /**
     * Creates a customer collection enumerator capable of traversing customers.
     * 
     * @param customerResourceCollection The initial customer resource collection to start from.
     * @return A customer collection enumerator capable of traversing customers.
     */
    IResourceCollectionEnumerator<T> create( T customerResourceCollection );

}
