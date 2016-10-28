package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerBillingProfile;

public class GetPartnerBillingProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PartnerBillingProfile partnerBillingProfile = partnerOperations.getProfiles().getPartnerBillingProfile().get();
        
        assertNotNull(partnerBillingProfile);
        assertNotNull(partnerBillingProfile.getAddress());
        assertNotNull(partnerBillingProfile.getAttributes());
        assertNotNull(partnerBillingProfile.getAttributes().getEtag());
        assertNotNull(partnerBillingProfile.getAttributes().getObjectType());
        assertNotNull(partnerBillingProfile.getBillingCurrency());
        assertNotNull(partnerBillingProfile.getCompanyName());
        assertNotNull(partnerBillingProfile.getLinks());
        assertNotNull(partnerBillingProfile.getLinks().getSelf());
        assertNotNull(partnerBillingProfile.getPrimaryContact());
        assertNotNull(partnerBillingProfile.getPurchaseOrderNumber());
        assertNotNull(partnerBillingProfile.getTaxId());
        assertNotNull(partnerBillingProfile.getProfileType());
        
    }
}
