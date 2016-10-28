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

public class SubscriptionsAddonsIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);
        
        ResourceCollection<Subscription> subscriptions = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();
        ResourceCollection<Subscription> subscriptionAddonsTry;
        ResourceCollection<Subscription> subscriptionAddons = null;
        
        for (Subscription subscription : subscriptions.getItems())
        {
           subscriptionAddonsTry = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().byId( subscription.getId() ).getAddOns().get();
           if (subscriptionAddonsTry.getTotalCount() > 0)
           {
               subscriptionAddons = subscriptionAddonsTry;
               break;
           }
        }

        assertNotNull( subscriptionAddons ); 
        assertTrue( subscriptionAddons.getTotalCount() > 0 );
        assertNotNull( subscriptionAddons.getItems().iterator().next() );
    }
}
