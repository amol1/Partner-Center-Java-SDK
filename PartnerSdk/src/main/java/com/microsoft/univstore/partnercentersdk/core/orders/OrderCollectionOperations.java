package com.microsoft.univstore.partnercentersdk.core.orders;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;

// -----------------------------------------------------------------------
// <copyright file="OrderCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Order collection operations implementation class.
 */
public class OrderCollectionOperations
    extends BasePartnerComponentString
    implements IOrderCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #OrderCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer tenant Id.
     */
    public OrderCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

    }

    /**
     * Places a new order for the customer.
     * 
     * @param newOrder The new order.
     * @return The newly created order.
     */
    @Override
    public Order create( Order newOrder )
    {
        if ( newOrder == null )
        {
            throw new IllegalArgumentException( "Order can't be null" );
        }
        IPartnerServiceProxy<Order, Order> partnerServiceProxy =
            new PartnerServiceProxy<Order, Order>( new TypeReference<Order>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOrders" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.post( newOrder );
    }

    /**
     * Obtains a specific order behavior.
     * 
     * @param orderId The order id.
     * @return The order operations.
     */
    @Override
    public IOrderOperations byId( String orderId )
    {
        return new OrderOperations( this.getPartner(), this.getContext(), orderId );
    }

    /**
     * Retrieves all the orders the customer made.
     * 
     * @return All the customer orders.
     */
    @Override
    public ResourceCollection<Order> get()
    {
        IPartnerServiceProxy<Order, ResourceCollection<Order>> partnerServiceProxy =
            new PartnerServiceProxy<Order, ResourceCollection<Order>>( new TypeReference<ResourceCollection<Order>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOrders" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }
}
