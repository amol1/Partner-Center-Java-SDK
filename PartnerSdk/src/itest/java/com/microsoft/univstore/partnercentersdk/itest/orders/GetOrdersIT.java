package com.microsoft.univstore.partnercentersdk.itest.orders;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;

public class GetOrdersIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);

        ResourceCollection<Order> orders = partnerOperations.getCustomers().byId( customer.getId() ).getOrders().get();

        assertNotNull( orders );  
        assertTrue(orders.getTotalCount() > 0);
        assertNotNull( orders.getItems().iterator().next() );
    }
}
