package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionMonthlyUsageRecord;

public class SubscriptionDailyUsageRecordsIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);
        
        ResourceCollection<SubscriptionMonthlyUsageRecord> usage = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().getUsageRecords().get();

        assertNotNull( usage ); 
        assertTrue(usage.getTotalCount() > 0);
        assertNotNull(usage.getItems().iterator().next());
    }
}
