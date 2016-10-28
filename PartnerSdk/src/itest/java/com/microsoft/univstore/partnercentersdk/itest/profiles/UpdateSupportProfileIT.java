package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerSupportProfile;

public class UpdateSupportProfileIT
{

    @Test
    public void test()
    {

        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PartnerSupportProfile currentPartnerSupportProfile =
            partnerOperations.getProfiles().getSupportProfile().get();

        String expectedEmail = currentPartnerSupportProfile.getEmail() + "J";
        String expectedTelephone = String.valueOf( new Random().nextInt( 100000000 ));
        String expectedWebsite = currentPartnerSupportProfile.getWebsite() + "J";
        
        PartnerSupportProfile newPartnerSupportProfile = new PartnerSupportProfile();
        newPartnerSupportProfile.setEmail( expectedEmail );
        newPartnerSupportProfile.setTelephone(expectedTelephone );
        newPartnerSupportProfile.setWebsite( expectedWebsite );

        PartnerSupportProfile updatedPartnerSupportProfile =
            partnerOperations.getProfiles().getSupportProfile().update(newPartnerSupportProfile);
        
        assertNotNull(updatedPartnerSupportProfile);
        assertEquals(expectedEmail, updatedPartnerSupportProfile.getEmail());
        assertEquals(expectedTelephone, updatedPartnerSupportProfile.getTelephone());
        assertEquals(expectedWebsite, updatedPartnerSupportProfile.getWebsite());

    }

}
