// -----------------------------------------------------------------------
// <copyright file="ResourceLinks.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.univstore.partnercentersdk.models;

/**
 * Represents the links associated with a resource.
 */
public class StandardResourceLinks
{
    /**
     * Gets or sets the self uri.
     */
    private Link __Self;

    public Link getSelf()
    {
        return __Self;
    }

    public void setSelf( Link value )
    {
        __Self = value;
    }

}
