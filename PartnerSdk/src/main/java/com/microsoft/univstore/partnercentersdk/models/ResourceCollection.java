package com.microsoft.univstore.partnercentersdk.models;

import java.util.ArrayList;
import java.util.List;

// -----------------------------------------------------------------------
// <copyright file="ResourceCollection.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Contains a collection of resources with JSON properties to represent the output Type of objects in collection
 */
public class ResourceCollection<TResource>
    extends ResourceCollectionWithLinks<TResource, StandardResourceCollectionLinks>
{
    /**
     * The collection items
     */
    private List<TResource> items;

    /**
     * Initializes a new instance of the {@link #ResourceCollection{T}} class.
     * 
     * @param items The items.
     */
    public ResourceCollection( List<TResource> items )
    {
        super( items );
        this.items = items;
    }

    /**
     * Initializes a new instance of the {@link #ResourceCollection{T}} class.
     * 
     * @param resourceCollection The resource collection.
     */
    protected ResourceCollection( ResourceCollection<TResource> resourceCollection )
    {
    	super(resourceCollection);
    }

}
