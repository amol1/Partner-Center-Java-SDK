// -----------------------------------------------------------------------
// <copyright file="SubscriptionLinks.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.univstore.partnercentersdk.models.subscriptions;

import com.microsoft.univstore.partnercentersdk.models.Link;
import com.microsoft.univstore.partnercentersdk.models.StandardResourceLinks;

/**
 * Bundles links associated with a subscription.
 */
public class SubscriptionLinks
    extends StandardResourceLinks
{
    /**
     * Gets or sets the offer link associated with the subscription.
     */
    private Link __Offer;

    public Link getOffer()
    {
        return __Offer;
    }

    public void setOffer( Link value )
    {
        __Offer = value;
    }

    /**
     * Gets or sets the entitlement link associated with the subscription.
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
     * Gets or sets the parent subscription link.
     */
    private Link __ParentSubscription;

    public Link getParentSubscription()
    {
        return __ParentSubscription;
    }

    public void setParentSubscription( Link value )
    {
        __ParentSubscription = value;
    }

}
