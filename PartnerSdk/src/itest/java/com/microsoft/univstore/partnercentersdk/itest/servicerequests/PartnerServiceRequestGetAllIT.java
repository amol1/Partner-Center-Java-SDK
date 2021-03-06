package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class PartnerServiceRequestGetAllIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations() ;

        ResourceCollection<ServiceRequest> serviceRequestCollection =
            partnerOperations.getServiceRequests().get();

        assertNotNull( serviceRequestCollection );
        assertTrue( serviceRequestCollection.getTotalCount() > 0 );
        assertNotNull( serviceRequestCollection.getItems().iterator().next() );

    }
}
