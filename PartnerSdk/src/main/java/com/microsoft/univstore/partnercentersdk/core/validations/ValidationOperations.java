package com.microsoft.univstore.partnercentersdk.core.validations;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.validations.CountryInformation;

// -----------------------------------------------------------------------
// <copyright file="ValidationOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The validations collection operations implementation.
 */
public class ValidationOperations
    extends BasePartnerComponentString
    implements IValidationOperations
{
    /**
     * Initializes a new instance of the {@link #ValidationOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public ValidationOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Checks the availability of a domain prefix.
     * 
     * @param domainPrefix The domain prefix to be verified.
     * @return A boolean value to indicate if the domain is available.
     */
    @Override
    public Boolean checkDomainAvailability( String domainPrefix )
    {
        if ( StringHelper.isNullOrWhiteSpace( domainPrefix ) )
        {
            throw new IllegalArgumentException( "The domain prefix is a required parameter." );
        }

        IPartnerServiceProxy<Boolean, Boolean> partnerServiceProxy =
            new PartnerServiceProxy<Boolean, Boolean>( new TypeReference<Boolean>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "CheckDomainAvailability" ).getPath(),
                                                        domainPrefix, Locale.US ) );
        return partnerServiceProxy.get();
    }

    /**
     * Gets the market specific validation data by country.
     * 
     * @param country The country.
     * @return The market specific validation data operations.
     */
    @Override
    public CountryInformation getMarketSpecificValidationDataByCountry( String country )
    {
        if ( StringHelper.isNullOrWhiteSpace( country ) )
        {
            throw new IllegalArgumentException( "The country is a required parameter." );
        }

        IPartnerServiceProxy<CountryInformation, CountryInformation> partnerServiceProxy =
            new PartnerServiceProxy<CountryInformation, CountryInformation>( new TypeReference<CountryInformation>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetMarketSpecificValidationDataByCountry" ).getPath(),
                                                        country, Locale.US ) );
        return partnerServiceProxy.get();
    }

}
