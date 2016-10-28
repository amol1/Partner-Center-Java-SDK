package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// <copyright file="ISubscriptionAddOnCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines the behavior for a subscription's add-ons.
 */
public interface ISubscriptionAddOnCollectionOperations
    extends IPartnerComponent<Tuple<String, String>>,
    IEntireEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>>
{
}
