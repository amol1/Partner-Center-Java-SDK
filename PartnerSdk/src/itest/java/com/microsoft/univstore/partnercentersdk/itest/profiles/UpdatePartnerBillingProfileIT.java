package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerBillingProfile;

public class UpdatePartnerBillingProfileIT
{

    @Test
    public void test()
    {

        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PartnerBillingProfile partnerBillingProfile =
            partnerOperations.getProfiles().getPartnerBillingProfile().get();

        String expectedPurchaseOrderNumber = partnerBillingProfile.getPurchaseOrderNumber() + "J";
        partnerBillingProfile.setPurchaseOrderNumber( expectedPurchaseOrderNumber );

        PartnerBillingProfile updatedPartnerBillingProfile =
            partnerOperations.getProfiles().getPartnerBillingProfile().update(partnerBillingProfile);
        
        assertNotNull(updatedPartnerBillingProfile);
        assertEquals(expectedPurchaseOrderNumber, updatedPartnerBillingProfile.getPurchaseOrderNumber());

    }

}
