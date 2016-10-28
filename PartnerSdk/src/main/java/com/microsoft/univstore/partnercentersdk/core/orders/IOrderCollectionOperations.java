package com.microsoft.univstore.partnercentersdk.core.orders;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCreateOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;

// -----------------------------------------------------------------------
// <copyright file="IOrderCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates customer orders behavior.
 */
public interface IOrderCollectionOperations
    extends IPartnerComponentString, IEntireEntityCollectionRetrievalOperations<Order, ResourceCollection<Order>>,
    IEntityCreateOperations<Order, Order>
{
    /**
     * Obtains a specific order behavior.
     * 
     * @param orderId The order id.
     * @return The order operations.
     */
    IOrderOperations byId( String orderId );

}
