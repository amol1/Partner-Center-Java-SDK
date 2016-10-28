package com.microsoft.univstore.partnercentersdk.core.orders;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="IOrderOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates a customer order behavior.
 */
public interface IOrderOperations
    extends IPartnerComponent<Tuple<String, String>>, IEntityGetOperations<Order>, IEntityUpdateOperations<Order>
{
}
