package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

public class GetSubscriptionsIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);

        ResourceCollection<Subscription> subscriptions = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();

        assertNotNull( subscriptions ); 
        assertTrue( subscriptions.getTotalCount() > 0 );
        assertNotNull( subscriptions.getItems().iterator().next() );
    }
}
