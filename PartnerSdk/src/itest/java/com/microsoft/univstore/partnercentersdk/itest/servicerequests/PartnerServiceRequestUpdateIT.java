package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequestNote;

public class PartnerServiceRequestUpdateIT
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
        
        String expectedNoteText = "Sample note from Java SDK number " + new Random().nextInt( 1000000 ) ;
        
        ServiceRequestNote newNote = new ServiceRequestNote();
        newNote.setText( expectedNoteText );
        
        selectedServiceRequest.setNewNote( newNote );

        ServiceRequest updatedServiceRequest = partnerOperations.getServiceRequests().byId( selectedServiceRequest.getId() ).update(selectedServiceRequest);
        assertNotNull( updatedServiceRequest );
        
        ServiceRequestNote note = null;
        
        for (ServiceRequestNote noteTry : updatedServiceRequest.getNotes())
        {
            if (noteTry.getText().equals( expectedNoteText ))
            {
                note = noteTry;
            }
        }
        assertNotNull(note);
    }
}
