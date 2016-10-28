package com.microsoft.univstore.partnercentersdk.models.orders;

import com.microsoft.univstore.partnercentersdk.models.Link;

// -----------------------------------------------------------------------
// <copyright file="OrderLineItemLinks.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Bundles the links for an order line item.
 */
public class OrderLineItemLinks
{
    /**
     * Gets or sets the entitlement link for the order line item.
     */
    private Link __Entitlement;

    public Link getEntitlement()
    {
        return __Entitlement;
    }

    public void setEntitlement( Link value )
    {
        __Entitlement = value;
    }

    /**
     * Gets or sets the subscription link for the order line item.
     */
    private Link __Subscription;

    public Link getSubscription()
    {
        return __Subscription;
    }

    public void setSubscription( Link value )
    {
        __Subscription = value;
    }

}
