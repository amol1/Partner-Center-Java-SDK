package com.microsoft.univstore.partnercentersdk.itest.offers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.offers.OfferCategory;

public class OffersByCategoryIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( "en-US" ) );
        
        OfferCategory category = OfferCategoriesHelper.getFirstOfferCategoryFromPagedQuery( partnerOperations );

        ResourceCollection<Offer> offerResults = partnerOperations.getOfferCategories().byId( category.getId() ).get( "US" );

        assertNotNull(offerResults);
        assertTrue( offerResults.getTotalCount() > 0 );        
        
        for (Offer offer : offerResults.getItems())
        {
            assertNotNull(offer);
            assertNotNull(offer.getCategory());
            assertEquals(category.getId(), offer.getCategory().getId());
        }
        
    }
}
