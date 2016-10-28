package com.microsoft.univstore.partnercentersdk.core.offers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;

// <copyright file="IOfferOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Holds operations that can be performed on a single offer.
 */
public interface IOfferOperations
    extends IPartnerComponentString
{
    /**
     * Gets the operations for the current offer's add-ons.
     */
    IOfferAddOnsOperations getAddOns();

    /**
     * Retrieves an offer for the provided offer Id, country.
     * 
     * @param country The country.
     * @return The requested offer for the given country and Id.
     */
    Offer get( String country );

}
