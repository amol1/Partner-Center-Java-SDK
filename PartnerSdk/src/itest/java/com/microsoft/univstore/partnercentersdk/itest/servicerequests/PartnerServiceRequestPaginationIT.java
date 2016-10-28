package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class PartnerServiceRequestPaginationIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create(UUID.randomUUID()) );

        int offset = 0;
        int pageSize = 50;

        PagedResourceCollection<ServiceRequest> serviceRequestCollection = null;

        do
        {
            serviceRequestCollection =
                partnerOperations.getServiceRequests().query( QueryFactory.buildIndexedQuery( pageSize, offset ) );

            assertNotNull( serviceRequestCollection );
            assertTrue( serviceRequestCollection.getTotalCount() > 0 );
            assertTrue( serviceRequestCollection.getTotalCount() <= pageSize );
            assertNotNull( serviceRequestCollection.getItems().iterator().next() );
            
            offset += serviceRequestCollection.getTotalCount();
        }
        while ( serviceRequestCollection.getLinks() != null && serviceRequestCollection.getLinks().getNext() != null );
    }
}
