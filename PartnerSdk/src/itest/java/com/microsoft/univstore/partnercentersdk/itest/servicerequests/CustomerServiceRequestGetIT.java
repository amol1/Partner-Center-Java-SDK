package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.ConfigurationHolder;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class CustomerServiceRequestGetIT
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

        ServiceRequest selectedServiceRequest = serviceRequestCollection.getItems().iterator().next();
        assertNotNull( selectedServiceRequest );

        ServiceRequest queriedServiceRequest =
            partnerOperations.getCustomers().byId( selectedCustomerId ).getServiceRequests().byId( selectedServiceRequest.getId() ).get();
        
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
