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
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="OfferCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Offer Collection operations implementation.
 */
public class OfferCollectionOperations
    extends BasePartnerComponentString
    implements IOfferCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #OfferCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param offerCategoryId The offer category Id.
     */
    public OfferCollectionOperations( IPartnerOperations rootPartnerOperations, String offerCategoryId )
    {
        super( rootPartnerOperations, offerCategoryId );
    }

    /**
     * Initializes a new instance of the {@link #OfferCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public OfferCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations, "" );
    }

    /**
     * Retrieves all the offers for the provided country.
     * 
     * @param country The country.
     * @return All offers for the provided country.
     */
    @Override
    public ResourceCollection<Offer> get( String country )
    {
        ParameterValidator.isValidUriQueryValue( country, "country is not a valid URI query value" );
        IPartnerServiceProxy<Offer, ResourceCollection<Offer>> partnerServiceProxy =
            new PartnerServiceProxy<Offer, ResourceCollection<Offer>>( new TypeReference<ResourceCollection<Offer>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOffers" ).getPath(),
                                                        Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOffers" ).getParameters().get( "Country" ),
                                                                                      country ) );
        if ( !StringHelper.isNullOrWhiteSpace( this.getContext() ) )
        {
            partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOffers" ).getParameters().get( "OfferCategoryId" ),
                                                                                          this.getContext() ) );
        }

        return partnerServiceProxy.get();
    }

    /**
     * Retrieves the operations tied with a specific offer.
     * 
     * @param offerId The offer id.
     * @return The offer operations.
     */
    @Override
    public IOfferOperations byId( String offerId )
    {
        return new OfferOperations( this.getPartner(), offerId );
    }

}
