package com.microsoft.univstore.partnercentersdk.core.factory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IndexBasedCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.models.ResourceBase;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;

// -----------------------------------------------------------------------
// <copyright file="IndexBasedCollectionEnumeratorFactory.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Factory method for creating a new instance of index based collection enumerator. The type of resource. /// The type
 * of resource collection.
 */
public class IndexBasedCollectionEnumeratorFactory<T extends ResourceBase, TResourceCollection extends ResourceCollection<T>>
    extends BasePartnerComponentString
    implements IResourceCollectionEnumeratorFactory<TResourceCollection>
{
    private TypeReference<TResourceCollection> responseType;

    /**
     * Initializes a new instance of the {@link #IndexBasedCollectionEnumeratorFactory{T, TResourceCollection}} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public IndexBasedCollectionEnumeratorFactory( IPartnerOperations rootPartnerOperations,
                                                  TypeReference<TResourceCollection> responseType )
    {
        super( rootPartnerOperations );
        this.responseType = responseType;
    }

    /**
     * Creates a index based collection enumerator capable of traversing resources that uses offset and page size for
     * pagination.
     * 
     * @param resourceCollection The initial resource collection to start from.
     * @return A customer collection enumerator capable of traversing customers.
     */
    @Override
    public IResourceCollectionEnumerator<TResourceCollection> create( TResourceCollection resourceCollection )
    {
        return new IndexBasedCollectionEnumerator<T, TResourceCollection>( this.getPartner(), resourceCollection, null,
                                                                           responseType );// new
                                                                                          // ResourceCollectionConverter<Invoice>());
    }

}
