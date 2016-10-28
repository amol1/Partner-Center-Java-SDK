package com.microsoft.univstore.partnercentersdk.core.offers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.OfferCategory;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="OfferCategoryCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Offers categories implementation.
 */
public class OfferCategoryCollectionOperations
    extends BasePartnerComponentString
    implements IOfferCategoryCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #OfferCategoryCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public OfferCategoryCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves all offer categories available to the partner for the provided country.
     * 
     * @param country The country.
     * @return All offer categories for the provided country.
     */
    @Override
    public ResourceCollection<OfferCategory> get( String country )
    {
        IPartnerServiceProxy<OfferCategory, ResourceCollection<OfferCategory>> partnerServiceProxy =
            new PartnerServiceProxy<OfferCategory, ResourceCollection<OfferCategory>>( new TypeReference<ResourceCollection<OfferCategory>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferCategories" ).getPath(),
                                                        Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOfferCategories" ).getParameters().get( "Country" ),
                                                                                      country ) );

        return partnerServiceProxy.get();
    }

    /**
     * Returns the offers in the context of an offer category.
     * 
     * @param categoryId The offers category Id.
     * @return The offers context which belongs to the given offer category.
     */
    @Override
    public IOfferCollectionOperations byId( String categoryId )
    {
        if ( StringHelper.isNullOrWhiteSpace( categoryId ) )
        {
            throw new IllegalArgumentException( "The categoryId field must be set." );
        }
        return new OfferCollectionOperations( this.getPartner(), categoryId );
    }

}
