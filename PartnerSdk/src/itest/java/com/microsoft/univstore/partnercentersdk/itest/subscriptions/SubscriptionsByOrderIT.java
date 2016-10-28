package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

public class SubscriptionsByOrderIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);
        
        ResourceCollection<Order> orders = partnerOperations.getCustomers().byId( customer.getId() ).getOrders().get();
        Order order = orders.getItems().iterator().next();

        ResourceCollection<Subscription> subscriptions = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().byOrder( order.getId() ).get();

        assertNotNull( subscriptions ); 
        assertTrue(subscriptions.getTotalCount() > 0);
        
        for (Subscription subscription : subscriptions.getItems())
        {
            assertEquals(order.getId(), subscription.getOrderId());
        }
    }
}
