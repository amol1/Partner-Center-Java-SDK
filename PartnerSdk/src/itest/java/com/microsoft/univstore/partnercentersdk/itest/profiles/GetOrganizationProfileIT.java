package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.OrganizationProfile;

public class GetOrganizationProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        OrganizationProfile organizationProfile = partnerOperations.getProfiles().getOrganizationProfile().get();
        
        assertNotNull(organizationProfile);
        assertNotNull(organizationProfile.getAttributes());
        assertNotNull(organizationProfile.getAttributes().getEtag());
        assertNotNull(organizationProfile.getAttributes().getObjectType());
        assertNotNull(organizationProfile.getCompanyName());
        assertNotNull(organizationProfile.getCulture());
        assertNotNull(organizationProfile.getDefaultAddress());
        assertNotNull(organizationProfile.getDomain());
        assertNotNull(organizationProfile.getEmail());
        assertNotNull(organizationProfile.getId());
        assertNotNull(organizationProfile.getLanguage());
        assertNotNull(organizationProfile.getLinks());
        assertNotNull(organizationProfile.getLinks().getSelf());
        //assertNotNull(organizationProfile.getPartnerId());
        assertNotNull(organizationProfile.getProfileType());
        assertNotNull(organizationProfile.getTenantId());
        
    }
}
