package com.microsoft.univstore.partnercentersdk.itest.orders;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;
import com.microsoft.univstore.partnercentersdk.models.orders.OrderStatus;

public class UpdateOrderIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery( partnerOperations );

        ResourceCollection<Order> orders = partnerOperations.getCustomers().byId( customer.getId() ).getOrders().get();

        Order order = orders.getItems().iterator().next();

        OrderStatus currentOrderStatus = order.getStatus();
        OrderStatus expectedOrderStatus;

        if ( currentOrderStatus == OrderStatus.PROCESSED )
        {
            expectedOrderStatus = OrderStatus.PENDING;

        }
        else
        {
            expectedOrderStatus = OrderStatus.PROCESSED;
        }
        order.setStatus( expectedOrderStatus );
        Order newOrder = new Order();
        newOrder.setStatus( expectedOrderStatus );
        newOrder.setLineItems( order.getLineItems() );

        Order updatedOrder =
            partnerOperations.getCustomers().byId( customer.getId() ).getOrders().byId( order.getId() ).update( newOrder );

        assertEquals( expectedOrderStatus, updatedOrder.getStatus() );
    }
}
