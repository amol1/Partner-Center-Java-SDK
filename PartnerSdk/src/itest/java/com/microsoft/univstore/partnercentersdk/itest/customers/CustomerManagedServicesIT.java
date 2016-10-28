package com.microsoft.univstore.partnercentersdk.itest.customers;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.customers.ManagedService;

public class CustomerManagedServicesIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);

        ResourceCollection<ManagedService> managedService = partnerOperations.getCustomers().byId( customer.getId() ).getManagedServices().get();

        assertNotNull( managedService );
        assertNotNull( managedService.getTotalCount() > 0 );
        assertNotNull( managedService.getItems().iterator().next() );
    }
}
