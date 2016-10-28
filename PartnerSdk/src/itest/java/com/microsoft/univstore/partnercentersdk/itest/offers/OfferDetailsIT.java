package com.microsoft.univstore.partnercentersdk.itest.offers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;

public class OfferDetailsIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations();
        
        ResourceCollection<Offer> offerResults = partnerOperations.getOffers().get( "US");
        Offer offer = offerResults.getItems().iterator().next();
                
        Offer offerInfo = partnerOperations.getOffers().byId( offer.getId() ).get( "US" );
        
        assertNotNull(offerInfo);
        assertNotNull(offerInfo.getAttributes());
        //assertNotNull(offerInfo.getAttributes().getEtag());
        assertNotNull(offerInfo.getAttributes().getObjectType());
        assertNotNull(offerInfo.getBilling());
        assertNotNull(offerInfo.getCategory());
        assertNotNull(offerInfo.getCountry());
        assertNotNull(offerInfo.getDescription());
        assertNotNull(offerInfo.getIsAddOn());
        assertNotNull(offerInfo.getIsAutoRenewable());
        assertNotNull(offerInfo.getIsAvailableForPurchase());
        assertNotNull(offerInfo.getLinks());
        assertNotNull(offerInfo.getLinks().getLearnMore());
        assertNotNull(offerInfo.getLocale());
        assertNotNull(offerInfo.getName());
        assertNotNull(offerInfo.getPrerequisiteOffers());
        assertNotNull(offerInfo.getProduct());
        assertNotNull(offerInfo.getUnitType());
        //assertNotNull(offerInfo.getUpgradeTargetOffers());
        assertNotNull(offerInfo.getUri());
    }
}
