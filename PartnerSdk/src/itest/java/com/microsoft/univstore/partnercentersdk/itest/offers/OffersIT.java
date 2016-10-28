package com.microsoft.univstore.partnercentersdk.itest.offers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;

public class OffersIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( "en-US" ) );

        ResourceCollection<Offer> offerResults = partnerOperations.getOffers().get( "US" );

        assertNotNull(offerResults);
        assertTrue( offerResults.getTotalCount() > 0 );        
        assertNotNull(offerResults.getItems().iterator().next());
    }
}
