package com.microsoft.univstore.partnercentersdk.core.enumerators;

import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;

// -----------------------------------------------------------------------
// <copyright file="IResourceCollectionEnumerator.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Provides resource collection enumeration capabilities. This interface can page through results and determines whether
 * the current page is the first or last page or not. The enumeration result type.
 */
public interface IResourceCollectionEnumerator<T extends ResourceBaseWithLinks>
{
    /**
     * Gets whether the current result collection is the first page of results or not.
     */
    boolean isFirstPage();

    /**
     * Gets whether the current result collection is the last page of results or not.
     */
    boolean isLastPage();

    /**
     * Gets whether the current result collection has a value or not. This indicates if the collection has been fully
     * enumerated or not.
     */
    boolean hasValue();

    /**
     * The current resource collection.
     */
    T getCurrent();

    /**
     * Retrieves the next result set.
     * 
     * @param context An optional request context. If not provided, the context associated with the partner operations
     *            will be used.
     */
    void next();

    void next( IRequestContext context );

    /**
     * Retrieves the previous result set.
     * 
     * @param context An optional request context. If not provided, the context associated with the partner operations
     *            will be used.
     */
    void previous();

    void previous( IRequestContext context );

}
