package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

// -----------------------------------------------------------------------
// <copyright file="ISubscriptionCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of the customer subscriptions as a whole.
 */
public interface ISubscriptionCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>>
{
    /**
     * Obtains the subscription usage records behavior for the customer.
     *
     * @return The customer subscription usage record.
     */
    ISubscriptionUsageRecordCollectionOperations getUsageRecords();

    /**
     * Groups customer subscriptions by an order.
     *
     * @param orderId The order id.
     * @return The order subscriptions operations.
     */
    IEntireEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>> byOrder( String orderId );

    /**
     * Groups customer subscriptions by a partner.
     *
     * @param partnerId The partner id.
     * @return The partner subscriptions operations.
     */
    IEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>> byPartner( String partnerId );

    /**
     * Retrieves a specific customer subscription behavior.
     *
     * @param subscriptionId The subscription id.
     * @return The customer subscription.
     */
    ISubscriptionOperations byId( String subscriptionId );

}
