package com.microsoft.univstore.partnercentersdk.core.orders;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="OrderOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Order operations implementation class.
 */
public class OrderOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements IOrderOperations
{
    /**
     * Initializes a new instance of the {@link #OrderOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id. ///
     * @param orderId The order Id.
     */
    public OrderOperations( IPartnerOperations rootPartnerOperations, String customerId, String orderId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( customerId, orderId ) );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

        if ( StringHelper.isNullOrWhiteSpace( orderId ) )
        {
            throw new IllegalArgumentException( "orderId must be set." );
        }

    }

    /**
     * Retrieves the customer order.
     * 
     * @return The customer order.
     */
    @Override
    public Order get()
    {
        IPartnerServiceProxy<Order, Order> partnerServiceProxy =
            new PartnerServiceProxy<Order, Order>( new TypeReference<Order>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOrder" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

    /**
     * Updates a customer order.
     * 
     * @param order The order to update.
     * @return The updated order.
     */
    @Override
    public Order update( Order order )
    {
        if ( order == null )
        {
            throw new IllegalArgumentException( "Order can't be null" );
        }
        IPartnerServiceProxy<Order, Order> partnerServiceProxy =
            new PartnerServiceProxy<Order, Order>( new TypeReference<Order>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "UpdateOrder" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );
        return partnerServiceProxy.patch( order );
    }

}
