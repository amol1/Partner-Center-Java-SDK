package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class PartnerServiceRequestGetIT
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

        ServiceRequest selectedServiceRequest = serviceRequestCollection.getItems().iterator().next();
        assertNotNull( selectedServiceRequest );

        ServiceRequest queriedServiceRequest = partnerOperations.getServiceRequests().byId( selectedServiceRequest.getId() ).get();
        assertNotNull( selectedServiceRequest );
        
        assertNotNull( queriedServiceRequest );
        assertNotNull( queriedServiceRequest.getAttributes() );
        //assertNotNull( queriedServiceRequest.getAttributes().getEtag() );
        assertNotNull( queriedServiceRequest.getAttributes().getObjectType() );
        //assertNotNull( queriedServiceRequest.getCountryCode() );
        assertNotNull( queriedServiceRequest.getCreatedDate() );
        assertNotNull( queriedServiceRequest.getDescription() );
        //assertNotNull( queriedServiceRequest.getFileLinks() );
        assertNotNull( queriedServiceRequest.getId() );
        assertNotNull( queriedServiceRequest.getLastClosedDate() );
        assertNotNull( queriedServiceRequest.getLastModifiedDate() );
        //assertNotNull( queriedServiceRequest.getLastUpdatedBy() );
        //assertNotNull( queriedServiceRequest.getNewNote() );
        assertNotNull( queriedServiceRequest.getNotes() );
        assertNotNull( queriedServiceRequest.getOrganization());      
        //assertNotNull( queriedServiceRequest.getPrimaryContact() );
        assertNotNull( queriedServiceRequest.getProductId() );
        //assertNotNull( queriedServiceRequest.getProductName() );
        assertNotNull( queriedServiceRequest.getSeverity() );
        assertNotNull( queriedServiceRequest.getStatus() );
        assertNotNull( queriedServiceRequest.getSupportTopicId() );
        assertNotNull( queriedServiceRequest.getSupportTopicName() );
        assertNotNull( queriedServiceRequest.getTitle() );
        

    }
}
