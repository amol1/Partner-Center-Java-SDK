package com.microsoft.univstore.partnercentersdk.core.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.partners.OrganizationProfile;

// -----------------------------------------------------------------------
// <copyright file="OrganizationProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The organization profile operations implementation.
 */
public class OrganizationProfileOperations
    extends BasePartnerComponentString
    implements IOrganizationProfileOperations
{
    /**
     * Initializes a new instance of the {@link #OrganizationProfileOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public OrganizationProfileOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the organization profile.
     * 
     * @return The organization profile.
     */
    @Override
    public OrganizationProfile get()
    {
        IPartnerServiceProxy<OrganizationProfile, OrganizationProfile> partnerServiceProxy =
            new PartnerServiceProxy<OrganizationProfile, OrganizationProfile>( new TypeReference<OrganizationProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOrganizationProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Updates the Organization Profile
     * 
     * @param updatePayload Payload of the update request
     * @return Updated Organization Profile
     */
    @Override
    public OrganizationProfile update( OrganizationProfile updatePayload )
    {
        IPartnerServiceProxy<OrganizationProfile, OrganizationProfile> partnerServiceProxy =
            new PartnerServiceProxy<OrganizationProfile, OrganizationProfile>( new TypeReference<OrganizationProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetOrganizationProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.put( updatePayload );
    }

}
