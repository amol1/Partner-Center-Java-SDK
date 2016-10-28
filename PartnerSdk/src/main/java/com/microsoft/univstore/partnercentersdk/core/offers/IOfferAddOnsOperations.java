package com.microsoft.univstore.partnercentersdk.core.offers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;

// <copyright file="IOfferAddOnsOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines the behavior of an offer's add-ons.
 */
public interface IOfferAddOnsOperations
    extends IPartnerComponentString
{
    /**
     * Retrieves all the offers for the provided country.
     * 
     * @param country The country.
     * @return The offers for the provided country.
     */
    ResourceCollection<Offer> get( String country );

    /**
     * Retrieves a subset of offers for the provided country.
     * 
     * @param country The country.
     * @param offset The starting index.
     * @param size The maximum number of offers to return.
     * @return The requested segment of the offers for the given country.
     */
    ResourceCollection<Offer> get( String country, int offset, int size );

}
