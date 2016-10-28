package com.microsoft.univstore.partnercentersdk.core.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerNetworkProfile;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="PartnerNetworkProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Class which contains operations for Partner Network Profile
 */
public class PartnerNetworkProfileOperations
    extends BasePartnerComponentString
    implements IPartnerNetworkProfileOperations
{
    /**
     * Initializes a new instance of the {@link #PartnerNetworkProfileOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public PartnerNetworkProfileOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the logged in reseller's PartnerNetworkProfile.
     * 
     * @return The partner network profile.
     */
    @Override
    public PartnerNetworkProfile get()
    {
        IPartnerServiceProxy<PartnerNetworkProfile, PartnerNetworkProfile> partnerServiceProxy =
            new PartnerServiceProxy<PartnerNetworkProfile, PartnerNetworkProfile>( new TypeReference<PartnerNetworkProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetPartnerNetworkProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Retrieves a PartnerNetworkProfile by MPN Id.
     * 
     * @param mpnId The MPN Id.
     * @return The partner network profile.
     */
    @Override
    public PartnerNetworkProfile get( String mpnId )
    {
        IPartnerServiceProxy<PartnerNetworkProfile, PartnerNetworkProfile> partnerServiceProxy =
            new PartnerServiceProxy<PartnerNetworkProfile, PartnerNetworkProfile>( new TypeReference<PartnerNetworkProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetPartnerNetworkProfile" ).getPath(),
                                                        Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetPartnerNetworkProfile" ).getParameters().get( "MpnId" ),
                                                                                      mpnId ) );

        return partnerServiceProxy.get();
    }

}
