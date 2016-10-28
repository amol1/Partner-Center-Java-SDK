package com.microsoft.univstore.partnercentersdk.samples.orders;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;
import com.microsoft.univstore.partnercentersdk.models.orders.OrderLineItem;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="CreateOrder.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that creates a new order for a customer.
 */
public class CreateOrder
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #CreateOrder} class.
     * 
     * @param context The scenario context.
     */
    public CreateOrder( IScenarioContext context )
    {
        super( "Create an order", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerId = this.obtainCustomerId( "Enter the ID of the customer making the purchase" );
        String offerId = this.obtainOfferId( "Enter the ID of the offer to purchase" );

        OrderLineItem lineItem = new OrderLineItem();
        lineItem.setOfferId( offerId );
        lineItem.setFriendlyName( "Java SDK Demo Order" );
        lineItem.setQuantity( 5 );

        List<OrderLineItem> lineItemList = new ArrayList<OrderLineItem>();
        lineItemList.add( lineItem );

        Order order = new Order();
        order.setLineItems( lineItemList );
        order.setReferenceCustomerId( customerId );

        this.getContext().getConsoleHelper().writeObject( order, "Order to be placed" );
        this.getContext().getConsoleHelper().startProgress( "Placing order" );
        Order createdOrder = partnerOperations.getCustomers().byId( customerId ).getOrders().create( order );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( createdOrder, "Created order" );
    }

}
