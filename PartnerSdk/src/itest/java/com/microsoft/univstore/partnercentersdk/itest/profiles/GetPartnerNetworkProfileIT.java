package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerNetworkProfile;

public class GetPartnerNetworkProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PartnerNetworkProfile partnerNetworkProfile = partnerOperations.getProfiles().getPartnerNetworkProfile().get("4458802");
        
        assertNotNull(partnerNetworkProfile);
        assertNotNull(partnerNetworkProfile.getAttributes() );
        //assertNotNull(partnerNetworkProfile.getAttributes().getEtag() );
        assertNotNull(partnerNetworkProfile.getAttributes().getObjectType() );
        assertNotNull(partnerNetworkProfile.getLinks() );
        assertNotNull(partnerNetworkProfile.getLinks().getSelf() );
        assertNotNull(partnerNetworkProfile.getMpnId() );
        assertNotNull(partnerNetworkProfile.getPartnerName() );
        assertNotNull(partnerNetworkProfile.getProfileType() );
        
        partnerNetworkProfile = partnerOperations.getProfiles().getPartnerNetworkProfile().get();
        
        assertNotNull(partnerNetworkProfile);
        assertNotNull(partnerNetworkProfile.getAttributes() );
        //assertNotNull(partnerNetworkProfile.getAttributes().getEtag() );
        assertNotNull(partnerNetworkProfile.getAttributes().getObjectType() );
        assertNotNull(partnerNetworkProfile.getLinks() );
        assertNotNull(partnerNetworkProfile.getLinks().getSelf() );
        assertNotNull(partnerNetworkProfile.getMpnId() );
        assertNotNull(partnerNetworkProfile.getPartnerName() );
        assertNotNull(partnerNetworkProfile.getProfileType() );
    }
}
