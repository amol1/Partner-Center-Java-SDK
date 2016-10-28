package com.microsoft.univstore.partnercentersdk.models.relationshiprequests;

import java.net.URI;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="CustomerRelationshipRequest.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents a customer relationship request with a partner.
 */
public class CustomerRelationshipRequest
    extends ResourceBase
{
    /**
     * Gets or sets the URL to be used by the customer to establish a relationship with a partner.
     */
    private URI __Url;

    public URI getUrl()
    {
        return __Url;
    }

    public void setUrl( URI value )
    {
        __Url = value;
    }

}
