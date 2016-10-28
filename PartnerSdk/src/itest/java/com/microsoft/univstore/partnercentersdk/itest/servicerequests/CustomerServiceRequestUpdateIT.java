package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.ConfigurationHolder;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequestNote;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequestStatus;

public class CustomerServiceRequestUpdateIT
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

        String expectedNoteText = "Sample Note";
        ServiceRequestStatus expectedStatus = ServiceRequestStatus.CLOSED;
        
        ServiceRequestNote expectedNote = new ServiceRequestNote();
        expectedNote.setText( expectedNoteText );
        
        ServiceRequest newServiceRequest = new ServiceRequest();
        newServiceRequest.setStatus( expectedStatus );
        newServiceRequest.setNewNote( expectedNote );
        
        ServiceRequest updatedServiceRequest =
            partnerOperations.getCustomers().byId( selectedCustomerId ).getServiceRequests().byId( selectedServiceRequest.getId() ).update(newServiceRequest);
        
        ServiceRequestNote lastNote = null;
        
        for (ServiceRequestNote note : updatedServiceRequest.getNotes())
        {
            if (lastNote == null)
            {
                lastNote = note;
            }
            else if (note.getCreatedDate().isAfter( lastNote.getCreatedDate() ))
            {
                lastNote = note;
            }
        }
        
        assertEquals(expectedNoteText, lastNote.getText());            
        assertEquals(expectedStatus, updatedServiceRequest.getStatus());
    }
}
