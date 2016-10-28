package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="PartnerServiceRequestOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements operations that can be performed on a single partner's service requests.
 */
public class PartnerServiceRequestOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements IServiceRequestOperations
{
    /**
     * Initializes a new instance of the {@link #PartnerServiceRequestOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param serviceRequestId The service request Id.
     */
    public PartnerServiceRequestOperations( IPartnerOperations rootPartnerOperations, String serviceRequestId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( serviceRequestId, "" ) );
        if ( StringHelper.isNullOrWhiteSpace( serviceRequestId ) )
        {
            throw new IllegalArgumentException( "serviceRequestId can't be null" );
        }

    }

    /**
     * Get Service Request By ID
     * 
     * @return Service Request
     */
    @Override
    public ServiceRequest get()
    {
        IPartnerServiceProxy<ServiceRequest, ServiceRequest> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, ServiceRequest>( new TypeReference<ServiceRequest>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetServiceRequestPartner" ).getPath(),
                                                        this.getContext().getItem1(), Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Updates a Service Request
     * 
     * @param updatePayload Payload of the update request
     * @return Updated Service Request
     */
    @Override
    public ServiceRequest update( ServiceRequest updatePayload )
    {
        IPartnerServiceProxy<ServiceRequest, ServiceRequest> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, ServiceRequest>( new TypeReference<ServiceRequest>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetServiceRequestPartner" ).getPath(),
                                                        this.getContext().getItem1(), Locale.US ) );

        return partnerServiceProxy.patch( updatePayload );
    }
}
