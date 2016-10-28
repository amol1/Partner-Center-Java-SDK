package com.microsoft.univstore.partnercentersdk.itest.orders;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;

public class GetOrderIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);

        ResourceCollection<Order> orders = partnerOperations.getCustomers().byId( customer.getId() ).getOrders().get();

        Order order = orders.getItems().iterator().next();
        
        Order queriedOrder = partnerOperations.getCustomers().byId( customer.getId() ).getOrders().byId( order.getId() ).get();

        assertNotNull( queriedOrder );  
        assertNotNull( queriedOrder.getAttributes() );  
        assertNotNull( queriedOrder.getAttributes().getEtag() );
        assertNotNull( queriedOrder.getAttributes().getObjectType() );
        assertNotNull( queriedOrder.getCreationDate() );
        assertNotNull( queriedOrder.getId() );
        assertNotNull( queriedOrder.getLineItems() );  
        assertNotNull( queriedOrder.getLineItems().iterator().next() );
        assertNotNull( queriedOrder.getReferenceCustomerId() );
        //assertNotNull( queriedOrder.getStatus() );
    }
}
