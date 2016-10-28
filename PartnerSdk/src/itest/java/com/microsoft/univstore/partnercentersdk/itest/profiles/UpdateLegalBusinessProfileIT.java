package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.LegalBusinessProfile;

public class UpdateLegalBusinessProfileIT
{

    @Test
    public void test()
    {

        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        LegalBusinessProfile legalBusinessProfile =
            partnerOperations.getProfiles().getLegalBusinessProfile().get();

        String expectedFirstName = legalBusinessProfile.getPrimaryContact().getFirstName() + "J";
                
        legalBusinessProfile.getPrimaryContact().setFirstName( expectedFirstName );

        LegalBusinessProfile updatedLegalBusinessProfile =
            partnerOperations.getProfiles().getLegalBusinessProfile().update(legalBusinessProfile);
        
        assertNotNull(updatedLegalBusinessProfile);
        assertEquals(expectedFirstName, updatedLegalBusinessProfile.getPrimaryContact().getFirstName());

    }

}
