package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.SubscriptionStatus;

public class UpdateSubscriptionIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        ResourceCollection<Customer> customerCollection = partnerOperations.getCustomers().get();
        Customer selectedCustomer = null;
        Subscription selectedSubscription = null;
        int expectedQuantity = 0;

        for ( Customer customer : customerCollection.getItems() )
        {
            ResourceCollection<Subscription> subscriptionCollection =
                partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();

            for ( Subscription subscription : subscriptionCollection.getItems() )
            {
                if ( subscription.getStatus() == SubscriptionStatus.ACTIVE )
                {
                    selectedCustomer = customer;
                    selectedSubscription = subscription;
                    expectedQuantity = subscription.getQuantity() + 1;
                    break;
                }
            }
            if (selectedSubscription != null)
            {
                break;
            }
        }
        
        Subscription newSubscription = new Subscription();

        newSubscription.setQuantity( expectedQuantity );

        Subscription updatedSubscription =
            partnerOperations.getCustomers().byId( selectedCustomer.getId() ).getSubscriptions().byId( selectedSubscription.getId() ).update( newSubscription );

        assertEquals( expectedQuantity, updatedSubscription.getQuantity() );
    }
}
