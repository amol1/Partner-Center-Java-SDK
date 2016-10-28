package com.microsoft.univstore.partnercentersdk.core.profiles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerBillingProfile;

// -----------------------------------------------------------------------
// <copyright file="PartnerBillingProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner billing profile operations implementation.
 */
public class PartnerBillingProfileOperations
    extends BasePartnerComponentString
    implements IPartnerBillingProfileOperations
{
    /**
     * Initializes a new instance of the {@link #PartnerBillingProfileOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public PartnerBillingProfileOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the partner billing profile.
     * 
     * @return The partner billing profile.
     */
    @Override
    public PartnerBillingProfile get()
    {
        IPartnerServiceProxy<PartnerBillingProfile, PartnerBillingProfile> partnerServiceProxy =
            new PartnerServiceProxy<PartnerBillingProfile, PartnerBillingProfile>( new TypeReference<PartnerBillingProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetPartnerBillingProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Updates the partner billing profile.
     * 
     * @param updatePayload Payload of the update request.
     * @return Updated partner billing profile.
     */
    @Override
    public PartnerBillingProfile update( PartnerBillingProfile updatePayload )
    {
        IPartnerServiceProxy<PartnerBillingProfile, PartnerBillingProfile> partnerServiceProxy =
            new PartnerServiceProxy<PartnerBillingProfile, PartnerBillingProfile>( new TypeReference<PartnerBillingProfile>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "UpdatePartnerBillingProfile" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.put( updatePayload );
    }

}
