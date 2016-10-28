package com.microsoft.univstore.partnercentersdk.itest.offers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.OfferCategory;

public class OfferCategoriesHelper
{

    public static OfferCategory getFirstOfferCategoryFromPagedQuery(IPartnerOperations partnerOperations)
    {
        ResourceCollection<OfferCategory> offerCategoryResults = partnerOperations.getOfferCategories().get( "US" );


        return offerCategoryResults.getItems().iterator().next();
    }
}
