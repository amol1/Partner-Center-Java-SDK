package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.OrganizationProfile;

public class UpdateOrganizationProfileIT
{

    @Test
    public void test()
    {

        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        OrganizationProfile organizationProfile =
            partnerOperations.getProfiles().getOrganizationProfile().get();

        String expectedEmail = organizationProfile.getEmail() + "J";
        String expectedFirstName = organizationProfile.getDefaultAddress().getFirstName() + "J";
        organizationProfile.setEmail( expectedEmail );
        organizationProfile.getDefaultAddress().setFirstName( expectedFirstName );

        OrganizationProfile updatedOrganizationProfile =
            partnerOperations.getProfiles().getOrganizationProfile().update(organizationProfile);
        
        assertNotNull(updatedOrganizationProfile);
        assertEquals(expectedEmail, updatedOrganizationProfile.getEmail());
        assertEquals(expectedFirstName, updatedOrganizationProfile.getDefaultAddress().getFirstName());

    }

}
