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
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionMonthlyUsageRecord;

public class SubscriptionUsageRecordsIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);
        
        ResourceCollection<Subscription> subscriptions = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();
        ResourceCollection<SubscriptionMonthlyUsageRecord> usageTry = null;
        ResourceCollection<SubscriptionMonthlyUsageRecord> usage = null;
        
        for (Subscription subscription : subscriptions.getItems())
        {
           if (subscription.getOfferId().startsWith( "MS-AZR" ))
           {
               usageTry = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().getUsageRecords().get();
               
               if (usageTry.getTotalCount() > 0) {
                   usage = usageTry;
                   break;
               }
           }
        }  
        
        assertNotNull( usage ); 
        assertTrue(usage.getTotalCount() > 0);
        assertNotNull(usage.getItems().iterator().next());
    }
}
