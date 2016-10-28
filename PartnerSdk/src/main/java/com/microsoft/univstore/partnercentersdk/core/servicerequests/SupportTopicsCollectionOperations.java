package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.SupportTopic;

// <copyright file="SupportTopicsCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The operations that can be performed on support topics. Support Topics operations are localizable.
 */
public class SupportTopicsCollectionOperations
    extends BasePartnerComponentString
    implements ISupportTopicsCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #SupportTopicsCollectionOperations} class with default locale.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public SupportTopicsCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Gets a collection of available support topics to create service request.
     * 
     * @return Collection of Support Topic Info.
     */
    @Override
    public ResourceCollection<SupportTopic> get()
    {
        IPartnerServiceProxy<SupportTopic, ResourceCollection<SupportTopic>> partnerServiceProxy =
            new PartnerServiceProxy<SupportTopic, ResourceCollection<SupportTopic>>( new TypeReference<ResourceCollection<SupportTopic>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetServiceRequestSupportTopics" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

}
