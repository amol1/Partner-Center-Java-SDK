package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.query.filters.FieldFilterOperation;
import com.microsoft.univstore.partnercentersdk.models.query.filters.FieldType;
import com.microsoft.univstore.partnercentersdk.models.query.filters.SimpleFieldFilter;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequestStatus;

public class PartnerServiceRequestFilteringIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create(UUID.randomUUID()) );

        PagedResourceCollection<ServiceRequest> serviceRequestCollection = partnerOperations.getServiceRequests().query( QueryFactory.buildIndexedQuery( 3, 0, new SimpleFieldFilter("Status", "Open", FieldFilterOperation.EQUALS, FieldType.ENUM) ) );

            assertNotNull( serviceRequestCollection );
            assertTrue( serviceRequestCollection.getTotalCount() > 0 );
            assertTrue( serviceRequestCollection.getTotalCount() <= 3 );

            for (ServiceRequest serviceRequest : serviceRequestCollection.getItems())
            {
                assertEquals(ServiceRequestStatus.OPEN, serviceRequest.getStatus());
            }
        
    }
}
