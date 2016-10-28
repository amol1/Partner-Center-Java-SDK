package com.microsoft.univstore.partnercentersdk.core.offers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.OfferCategory;

// -----------------------------------------------------------------------
// <copyright file="IOfferCategoryCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of offer categories available to partners.
 */
public interface IOfferCategoryCollectionOperations
    extends IPartnerComponentString
{
    /**
     * Retrieves all offer categories available to the partner for the provided country.
     * 
     * @param country The country.
     * @return All offer categories for the provided country.
     */
    ResourceCollection<OfferCategory> get( String country );

    /**
     * Returns the offers in the context of an offer category.
     * 
     * @param categoryId The offers category Id.
     * @return The offers context which belongs to the given offer category.
     */
    IOfferCollectionOperations byId( String categoryId );

}
