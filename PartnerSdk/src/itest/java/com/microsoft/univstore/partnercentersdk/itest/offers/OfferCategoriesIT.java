package com.microsoft.univstore.partnercentersdk.itest.offers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.OfferCategory;

public class OfferCategoriesIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( "en-US" ) );

        ResourceCollection<OfferCategory> offerCategoryResults = partnerOperations.getOfferCategories().get( "US" );

        assertNotNull(offerCategoryResults);
        assertTrue( offerCategoryResults.getTotalCount() > 0 );
        assertNotNull( offerCategoryResults.getItems().iterator().next());
    }
}
