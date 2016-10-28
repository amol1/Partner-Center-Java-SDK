package com.microsoft.univstore.partnercentersdk.core.offers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.ParameterValidator;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// <copyright file="OfferAddOnsOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements offer add-ons behavior.
 */
public class OfferAddOnsOperations
    extends BasePartnerComponentString
    implements IOfferAddOnsOperations
{
    /**
     * Initializes a new instance of the {@link #OfferAddOnsOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param offerId The offer Id to get its add on offers.
     */
    public OfferAddOnsOperations( IPartnerOperations rootPartnerOperations, String offerId )
    {
        super( rootPartnerOperations, offerId );
        // ParameterValidator.Required(offerId, "offerId must be set");
    }

    /**
     * Retrieves the add-ons for the given offer.
     * 
     * @param country The country.
     * @return The offer add-ons.
     */
    @Override
    public ResourceCollection<Offer> get( String country )
    {
        ParameterValidator.isValidUriQueryValue( country, "country is not a valid URI query value" );
        IPartnerServiceProxy<ResourceCollection<Offer>, ResourceCollection<Offer>> partnerServiceProxy =
            new PartnerServiceProxy<ResourceCollection<Offer>, ResourceCollection<Offer>>( new TypeReference<ResourceCollection<Offer>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferAddons" ).getPath(),
                                                        Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferAddons" ).getParameters().get( "Country" ),
                                                                                      country ) );
        return partnerServiceProxy.get();
    }

    /**
     * Asynchronously retrieves a subset of offers for the provided country.
     * 
     * @param country The country.
     * @param offset The starting index.
     * @param size The maximum number of offers to return.
     * @return The requested segment of the offers for the provided country.
     */
    @Override
    public ResourceCollection<Offer> get( String country, int offset, int size )
    {
        ParameterValidator.isValidUriQueryValue( country, "country is not a valid URI query value" );
        ParameterValidator.isIntInclusive( 0, Integer.MAX_VALUE, offset, "offset has to be non-negative." );
        ParameterValidator.isIntInclusive( 1, Integer.MAX_VALUE, size, "size has to be positive." );
        IPartnerServiceProxy<Offer, ResourceCollection<Offer>> partnerServiceProxy =
            new PartnerServiceProxy<Offer, ResourceCollection<Offer>>( new TypeReference<ResourceCollection<Offer>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferAddons" ).getPath(),
                                                        Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferAddons" ).getParameters().get( "Country" ),
                                                                                      country ) );
        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferAddons" ).getParameters().get( "Offset" ),
                                                                                      String.valueOf( offset ) ) );
        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferAddons" ).getParameters().get( "Size" ),
                                                                                      String.valueOf( size ) ) );

        return partnerServiceProxy.get();
    }

}
