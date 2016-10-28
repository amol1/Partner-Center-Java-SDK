package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCreateOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Upgrade;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.UpgradeResult;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="ISubscriptionUpgradeCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This interface defines the upgrade operations available on a customer's subscription.
 */
public interface ISubscriptionUpgradeCollectionOperations
    extends IPartnerComponent<Tuple<String, String>>,
    IEntireEntityCollectionRetrievalOperations<Upgrade, ResourceCollection<Upgrade>>,
    IEntityCreateOperations<Upgrade, UpgradeResult>
{
}
