package com.microsoft.univstore.partnercentersdk.core.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerProfileType;

// -----------------------------------------------------------------------
// <copyright file="PartnerProfileTypeCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner profile types operations implementation.
 */
public class PartnerProfileTypeCollectionOperations
    extends BasePartnerComponentString
    implements IPartnerProfileTypeCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #PartnerProfileTypeCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public PartnerProfileTypeCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Gets all the applicable profile types.
     * 
     * @return All the applicable profile types.
     */
    @Override
    public ResourceCollection<PartnerProfileType> get()
    {
        IPartnerServiceProxy<PartnerProfileType, ResourceCollection<PartnerProfileType>> partnerServiceProxy =
            new PartnerServiceProxy<PartnerProfileType, ResourceCollection<PartnerProfileType>>( new TypeReference<ResourceCollection<PartnerProfileType>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetAllProfileTypes" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

}
