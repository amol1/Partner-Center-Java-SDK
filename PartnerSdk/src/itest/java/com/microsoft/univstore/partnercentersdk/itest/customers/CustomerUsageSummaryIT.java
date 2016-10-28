package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.CustomerUsageSummary;

public class CustomerUsageSummaryIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer selectedCustomer = CustomerHelper.getFirstCustomerFromPagedQuery( partnerOperations );
        
        CustomerUsageSummary usageSummary = partnerOperations.getCustomers().byId( selectedCustomer.getId() ).getUsageSummary().get();
        
        assertNotNull(usageSummary);
        assertNotNull(usageSummary.getAttributes());
        //assertNotNull(usageSummary.getAttributes().getEtag());
        assertNotNull(usageSummary.getAttributes().getObjectType());
        assertNotNull(usageSummary.getBillingEndDate());
        assertNotNull(usageSummary.getBillingStartDate());
        assertNotNull(usageSummary.getCurrencyLocale());
        assertNotNull(usageSummary.getBudget());
        assertNotNull(usageSummary.getId());
        assertNotNull(usageSummary.getLinks());
        assertNotNull(usageSummary.getLinks().getSelf());
        assertNotNull(usageSummary.getName());
    }
}
