package com.microsoft.univstore.partnercentersdk.models;

// -----------------------------------------------------------------------
// <copyright file="ResourceBaseWithLinks.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Base class for resources
 */
public abstract class ResourceBaseWithLinks<TLinks>
    extends ResourceBase
{
    /**
     * Initializes a new instance of the {@link #ResourceBaseWithLinks} class.
     * 
     * @param objectType Type of the object.
     */
    protected ResourceBaseWithLinks( String objectType )
    {
        super( objectType );
        //this.__Links = new TLinks();
    }

    /**
     * Initializes a new instance of the {@link #ResourceBaseWithLinks} class.
     */
    protected ResourceBaseWithLinks()
    {
        super();
    }

    /**
     * Gets or sets the links.
     */
    private TLinks __Links;

    public TLinks getLinks()
    {
        return __Links;
    }

    public void setLinks( TLinks value )
    {
        __Links = value;
    }

}
