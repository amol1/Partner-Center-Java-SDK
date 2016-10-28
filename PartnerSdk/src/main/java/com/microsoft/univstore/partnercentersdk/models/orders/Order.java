package com.microsoft.univstore.partnercentersdk.models.orders;

import org.joda.time.DateTime;

import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;

// -----------------------------------------------------------------------
// <copyright file="Order.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Order represents collection of information needed to purchase offers represented by each order line items.
 */
// @JsonInclude(Include.ALWAYS)
public class Order
    extends ResourceBaseWithLinks
{
    /**
     * Gets or sets the order identifier.
     */
    private String __Id;

    public String getId()
    {
        return __Id;
    }

    public void setId( String value )
    {
        __Id = value;
    }

    /**
     * Gets or sets the reference customer identifier.
     */
    private String __ReferenceCustomerId;

    public String getReferenceCustomerId()
    {
        return __ReferenceCustomerId;
    }

    public void setReferenceCustomerId( String value )
    {
        __ReferenceCustomerId = value;
    }

    /**
     * Gets or sets the Order line items. Each order line item refers to one offer purchase data.
     */
    private Iterable<OrderLineItem> __LineItems;

    public Iterable<OrderLineItem> getLineItems()
    {
        return __LineItems;
    }

    public void setLineItems( Iterable<OrderLineItem> value )
    {
        __LineItems = value;
    }

    /**
     * Gets or sets the order status.
     */
    private OrderStatus __Status;

    public OrderStatus getStatus()
    {
        return __Status;
    }

    public void setStatus( OrderStatus value )
    {
        __Status = value;
    }

    /**
     * Gets or sets the creation date of the order
     */
    private DateTime __CreationDate;

    public DateTime getCreationDate()
    {
        return __CreationDate;
    }

    public void setCreationDate( DateTime value )
    {
        __CreationDate = value;
    }

}
