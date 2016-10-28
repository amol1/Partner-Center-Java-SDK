package com.microsoft.univstore.partnercentersdk.core.offers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;

// -----------------------------------------------------------------------
// <copyright file="IOfferCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates the basic offers behavior.
 */
public interface IOfferCollectionOperations
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
     * Retrieves the operations tied with a specific offer.
     * 
     * @param offerId The offer id.
     * @return The offer operations.
     */
    IOfferOperations byId( String offerId );

}
