package com.microsoft.univstore.partnercentersdk.core.enumerators;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceBase;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;

// -----------------------------------------------------------------------
// <copyright file="IndexBasedCollectionEnumerator.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Enumerator for index based pagination Index based - Paged query where index and page size is used. The type of
 * resource /// The type of resource collection.
 */
public class IndexBasedCollectionEnumerator<T extends ResourceBase, TResourceCollection extends ResourceCollection<T>>
    extends BaseResourceCollectionEnumerator<TResourceCollection>
{
    /**
     * Initializes a new instance of the {@link #IndexBasedCollectionEnumerator{T, TResourceCollection}} class.
     * 
     * @param partnerOperations A partner operations instance.
     * @param pagedResourceCollection The paged resource collection to enumerate from.
     * @param resourceCollectionConverter Optional: The resource collection converter.
     */
    public IndexBasedCollectionEnumerator( IPartnerOperations partnerOperations,
                                           TResourceCollection pagedResourceCollection,
                                           ObjectMapper resourceCollectionConverter,
                                           TypeReference<TResourceCollection> responseType )
    {
        super( partnerOperations, pagedResourceCollection, resourceCollectionConverter, responseType );
    }

}
