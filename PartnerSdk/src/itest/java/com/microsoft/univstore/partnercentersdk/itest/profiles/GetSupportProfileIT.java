package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerSupportProfile;

public class GetSupportProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PartnerSupportProfile partnerSupportProfile = partnerOperations.getProfiles().getSupportProfile().get();
        
        assertNotNull(partnerSupportProfile);
        assertNotNull(partnerSupportProfile.getAttributes());
        //assertNotNull(partnerSupportProfile.getAttributes().getEtag());
        assertNotNull(partnerSupportProfile.getAttributes().getObjectType());
        assertNotNull(partnerSupportProfile.getEmail());
        assertNotNull(partnerSupportProfile.getLinks());
        assertNotNull(partnerSupportProfile.getLinks().getSelf());
        assertNotNull(partnerSupportProfile.getProfileType());
        assertNotNull(partnerSupportProfile.getTelephone());
        assertNotNull(partnerSupportProfile.getWebsite());
    }
}
