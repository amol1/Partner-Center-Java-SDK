package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.ConfigurationHolder;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class CustomerServiceRequestGetAllIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        String selectedCustomerId =
            ConfigurationHolder.getInstance().getConfiguration().get( "customerWithServiceRequests" );

        ResourceCollection<ServiceRequest> serviceRequestCollection =
            partnerOperations.getCustomers().byId( selectedCustomerId ).getServiceRequests().get();

        assertNotNull( serviceRequestCollection );
        assertTrue( serviceRequestCollection.getTotalCount() > 0 );
        assertNotNull( serviceRequestCollection.getItems().iterator().next() );

    }
}
