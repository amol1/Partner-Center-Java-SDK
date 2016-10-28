package com.microsoft.univstore.partnercentersdk.core.validations;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.models.validations.CountryInformation;

// -----------------------------------------------------------------------
// <copyright file="IValidationOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of the validations.
 */
public interface IValidationOperations
    extends IPartnerComponentString
{
    /**
     * Checks the availability of a domain prefix.
     * 
     * @param domainPrefix The domain prefix to be verified.
     * @return A boolean value to indicate if the domain is available.
     */
    Boolean checkDomainAvailability( String domainPrefix );

    /**
     * Gets the market specific validation data by country.
     * 
     * @param country The country.
     * @return The market specific validation data operations.
     */
    CountryInformation getMarketSpecificValidationDataByCountry( String country );

}
