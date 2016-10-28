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
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="OfferOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Single offer operations implementation.
 */
public class OfferOperations
    extends BasePartnerComponentString
    implements IOfferOperations
{
    /**
     * The offer add on operations.
     */
    private IOfferAddOnsOperations addOns;

    private String offerId;

    /**
     * Initializes a new instance of the {@link #OfferOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param offerId The offer Id.
     */
    public OfferOperations( IPartnerOperations rootPartnerOperations, String offerId )
    {
        super( rootPartnerOperations, offerId );
        this.offerId = offerId;
    }

    /**
     * Gets the operations for the current offer's add-ons.
     */
    @Override
    public IOfferAddOnsOperations getAddOns()
    {
        if ( this.addOns == null )
        {
            this.addOns = new OfferAddOnsOperations( this.getPartner(), this.offerId );
        }
        return this.addOns;
    }

    /**
     * Retrieves the offer details.
     * 
     * @param country The country.
     * @return The offer details.
     */
    @Override
    public Offer get( String country )
    {
        ParameterValidator.isValidUriQueryValue( country, "country is not a valid URI query value" );
        IPartnerServiceProxy<Offer, Offer> partnerServiceProxy =
            new PartnerServiceProxy<Offer, Offer>( new TypeReference<Offer>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOffer" ).getPath(),
                                                        this.getContext(), Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOffers" ).getParameters().get( "Country" ),
                                                                                      country ) );

        return partnerServiceProxy.get();
    }

}
