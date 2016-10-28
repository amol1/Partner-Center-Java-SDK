package com.microsoft.univstore.partnercentersdk.core.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.partners.LegalBusinessProfile;

// -----------------------------------------------------------------------
// <copyright file="LegalBusinessProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The legal business profile operations implementation.
 */
public class LegalBusinessProfileOperations
    extends BasePartnerComponentString
    implements ILegalBusinessProfileOperations
{
    /**
     * Initializes a new instance of the {@link #LegalBusinessProfileOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public LegalBusinessProfileOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the legal business profile.
     * 
     * @return The legal business profile.
     */
    @Override
    public LegalBusinessProfile get()
    {
        IPartnerServiceProxy<LegalBusinessProfile, LegalBusinessProfile> partnerServiceProxy =
            new PartnerServiceProxy<LegalBusinessProfile, LegalBusinessProfile>( new TypeReference<LegalBusinessProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetLegalBusinessProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Updates the Legal Business Profile.
     * 
     * @param legalBusinessProfile Payload of the update request.
     * @return Updated Legal Business Profile.
     */
    @Override
    public LegalBusinessProfile update( LegalBusinessProfile legalBusinessProfile )
    {
        IPartnerServiceProxy<LegalBusinessProfile, LegalBusinessProfile> partnerServiceProxy =
            new PartnerServiceProxy<LegalBusinessProfile, LegalBusinessProfile>( new TypeReference<LegalBusinessProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetLegalBusinessProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.put( legalBusinessProfile );
    }

}
