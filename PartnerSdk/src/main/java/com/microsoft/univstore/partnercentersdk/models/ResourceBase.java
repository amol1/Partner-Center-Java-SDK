package com.microsoft.univstore.partnercentersdk.models;

// -----------------------------------------------------------------------
// <copyright file="ResourceBase.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Base class for resources
 */
public abstract class ResourceBase
{
    /**
     * The resource attributes.
     */
    private final ResourceAttributes attributes;

    /**
     * Initializes a new instance of the {@link #ResourceBase} class.
     */
    protected ResourceBase()
    {
        this.attributes = new ResourceAttributes( this.getClass() );
    }

    /**
     * Initializes a new instance of the {@link #ResourceBase} class.
     * 
     * @param objectType Type of the object.
     */
    protected ResourceBase( String objectType )
    {
        this();
        this.attributes.setObjectType( objectType );
    }

    /**
     * Gets the attributes.
     */
    public ResourceAttributes getAttributes()
    {
        return this.attributes;
    }

}
