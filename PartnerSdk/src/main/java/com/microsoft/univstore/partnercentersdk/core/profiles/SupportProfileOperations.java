package com.microsoft.univstore.partnercentersdk.core.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerSupportProfile;

// -----------------------------------------------------------------------
// <copyright file="SupportProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner support profile operations implementation.
 */
public class SupportProfileOperations
    extends BasePartnerComponentString
    implements ISupportProfileOperations
{
    /**
     * Initializes a new instance of the {@link #SupportProfileOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public SupportProfileOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the partner support profile.
     * 
     * @return The partner support profile.
     */
    @Override
    public PartnerSupportProfile get()
    {
        IPartnerServiceProxy<PartnerSupportProfile, PartnerSupportProfile> partnerServiceProxy =
            new PartnerServiceProxy<PartnerSupportProfile, PartnerSupportProfile>( new TypeReference<PartnerSupportProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetSupportProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Updates the Partner Support Profile
     * 
     * @param updatePayload Payload of the update request
     * @return Updated PartnerSupportProfile
     */
    @Override
    public PartnerSupportProfile update( PartnerSupportProfile updatePayload )
    {
        IPartnerServiceProxy<PartnerSupportProfile, PartnerSupportProfile> partnerServiceProxy =
            new PartnerServiceProxy<PartnerSupportProfile, PartnerSupportProfile>( new TypeReference<PartnerSupportProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "UpdateSupportProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.put( updatePayload );
    }

}
