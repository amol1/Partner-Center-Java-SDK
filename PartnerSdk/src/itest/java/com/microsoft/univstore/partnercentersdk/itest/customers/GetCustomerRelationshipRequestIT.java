package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.relationshiprequests.CustomerRelationshipRequest;

public class GetCustomerRelationshipRequestIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();
        
        CustomerRelationshipRequest relationshipRequest = partnerOperations.getCustomers().getRelationshipRequests().get();
        
        assertNotNull(relationshipRequest);
        assertNotNull(relationshipRequest.getAttributes());
        //assertNotNull(relationshipRequest.getAttributes().getEtag());
        assertNotNull(relationshipRequest.getAttributes().getObjectType());
        assertNotNull(relationshipRequest.getUrl());
    }
}
