package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class PartnerServiceRequestSimpleQuerySearchIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations() ;

        PagedResourceCollection<ServiceRequest> serviceRequestCollection =
            partnerOperations.getServiceRequests().query( QueryFactory.buildSimpleQuery() );

        assertNotNull( serviceRequestCollection );
        assertTrue( serviceRequestCollection.getTotalCount() > 0 );  
        assertNotNull( serviceRequestCollection );  
    }
}
