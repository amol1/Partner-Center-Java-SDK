package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequestSeverity;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.SupportTopic;

public class PartnerServiceRequestCreateIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( "de-DE" ) );

        ResourceCollection<SupportTopic> supportTopicsCollection =
            partnerOperations.getServiceRequests().getSupportTopics().get();

        assertNotNull( supportTopicsCollection );
        assertTrue( supportTopicsCollection.getTotalCount() > 0 );

        SupportTopic selectedSupportTopic = supportTopicsCollection.getItems().iterator().next();
        assertNotNull( selectedSupportTopic );

        String expectedTitle = "TrialSR";
        String expectedDescription = "Ignore this SR";
        ServiceRequestSeverity expectedSeverity = ServiceRequestSeverity.CRITICAL;
        SupportTopic expectedSupportTopic = selectedSupportTopic;

        ServiceRequest newServiceRequest = new ServiceRequest();
        newServiceRequest.setTitle( expectedTitle );
        newServiceRequest.setDescription( expectedDescription );
        newServiceRequest.setSeverity( expectedSeverity );
        newServiceRequest.setSupportTopicId( String.valueOf( expectedSupportTopic.getId() ) );

        ServiceRequest createdServiceRequest =
            partnerOperations.getServiceRequests().create( newServiceRequest, "ru-ru" );

        assertNotNull( createdServiceRequest );
        assertEquals( expectedTitle, createdServiceRequest.getTitle() );
        assertEquals( expectedDescription, createdServiceRequest.getDescription() );
        assertEquals( expectedSeverity, createdServiceRequest.getSeverity() );
        assertEquals( String.valueOf( expectedSupportTopic.getId()), createdServiceRequest.getSupportTopicId() );

        assertNotNull( createdServiceRequest.getAttributes() );
        //assertNotNull( createdServiceRequest.getAttributes().getEtag() );
        assertNotNull( createdServiceRequest.getAttributes().getObjectType() );
        assertNotNull( createdServiceRequest.getCountryCode() );
        assertNotNull( createdServiceRequest.getCreatedDate() );
        //assertNotNull( createdServiceRequest.getFileLinks() );
        assertNotNull( createdServiceRequest.getId() );
        assertNotNull( createdServiceRequest.getLastClosedDate() );
        assertNotNull( createdServiceRequest.getLastModifiedDate() );
        //assertNotNull( createdServiceRequest.getLastUpdatedBy() );
        //assertNotNull( createdServiceRequest.getNewNote() );
        //assertNotNull( createdServiceRequest.getNotes() );
        assertNotNull( createdServiceRequest.getPrimaryContact() );
        //assertNotNull( createdServiceRequest.getProductId() );
        //assertNotNull( createdServiceRequest.getProductName() );
        assertNotNull( createdServiceRequest.getStatus() );
        //assertNotNull( createdServiceRequest.getSupportTopicName() );

    }
}
