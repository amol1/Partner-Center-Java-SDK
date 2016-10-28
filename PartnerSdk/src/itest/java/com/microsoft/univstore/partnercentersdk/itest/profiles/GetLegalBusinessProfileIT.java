package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.LegalBusinessProfile;

public class GetLegalBusinessProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        LegalBusinessProfile legalBusinessProfile = partnerOperations.getProfiles().getLegalBusinessProfile().get();
        
        assertNotNull(legalBusinessProfile);
        assertNotNull(legalBusinessProfile.getAddress());
        assertNotNull(legalBusinessProfile.getAttributes());
        //assertNotNull(legalBusinessProfile.getAttributes().getEtag());
        assertNotNull(legalBusinessProfile.getAttributes().getObjectType());
        assertNotNull(legalBusinessProfile.getCompanyApproverAddress());
        assertNotNull(legalBusinessProfile.getCompanyApproverEmail());
        assertNotNull(legalBusinessProfile.getCompanyName());
        assertNotNull(legalBusinessProfile.getLinks());
        assertNotNull(legalBusinessProfile.getLinks().getSelf());
        assertNotNull(legalBusinessProfile.getPrimaryContact());
        assertNotNull(legalBusinessProfile.getProfileType());
    }
}
