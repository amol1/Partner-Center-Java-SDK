package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerMonthlyUsageRecord;

public class AllCustomerUsageRecordsIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();
        
        ResourceCollection<CustomerMonthlyUsageRecord> usageRecord = partnerOperations.getCustomers().getUsageRecords().get();
        
        assertNotNull(usageRecord);
        assertTrue(usageRecord.getTotalCount() > 0);
        assertNotNull(usageRecord.getItems().iterator().next());
    }
}
