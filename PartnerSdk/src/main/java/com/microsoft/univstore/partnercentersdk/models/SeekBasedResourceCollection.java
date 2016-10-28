package com.microsoft.univstore.partnercentersdk.models;

import java.util.List;

// -----------------------------------------------------------------------
// <copyright file="PagedResourceCollection.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Paged Resource Collection Type of objects in collection
 */
public class SeekBasedResourceCollection<T>
    extends ResourceCollection<T>
{
    /**
     * Initializes a new instance of the {@link #PagedResourceCollection{T}} class.
     * 
     * @param items The items collection.
     */
    public SeekBasedResourceCollection( List<T> items )

    {
        super( items );
    }

    /**
     * Initializes a new instance of the {@link #PagedResourceCollection{T}} class.
     * 
     * @param resourceCollection The resource collection.
     */
    public SeekBasedResourceCollection( ResourceCollection<T> resourceCollection )

    {
        super( resourceCollection );
    }

    /**
     * Initializes a new instance of the {@link #PagedResourceCollection{T}} class.
     * 
     * @param items The items.
     * @param continuationToken The continuation token.
     */
    public SeekBasedResourceCollection( List<T> items, String continuationToken )

    {
        this( items );
        this.setContinuationToken( continuationToken );
    }

    /**
     * Gets or sets the continuation token.
     */
    private String __ContinuationToken = new String();

    public String getContinuationToken()
    {
        return __ContinuationToken;
    }

    public void setContinuationToken( String value )
    {
        __ContinuationToken = value;
    }

}
