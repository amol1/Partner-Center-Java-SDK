package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

public class SubscriptionHelper
{

    public static Subscription getFirstSubscriptionFromPagedQuery(IPartnerOperations partnerOperations, Customer customer)
    {        
        ResourceCollection<Subscription> subscriptions =
            partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get() ;

        return subscriptions.getItems().iterator().next();
    }
}
