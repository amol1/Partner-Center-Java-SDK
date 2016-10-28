package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerErrorCategory;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.ParameterValidator;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.query.IQuery;
import com.microsoft.univstore.partnercentersdk.models.query.QueryType;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="PartnerServiceRequestCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner's service requests operations and implementation.
 */
public class PartnerServiceRequestCollectionOperations
    extends BasePartnerComponentString
    implements IPartnerServiceRequestCollectionOperations
{
    /**
     * Represents a partner tenant id
     */
    private static final String ImplicitOrganizationId = "my-org";

    /**
     * The minimum allowed page size for the collection.
     */
    private static final int MIN_PAGE_SIZE = 1;

    /**
     * The maximum allowed page size for the collection.
     */
    private static final int MAX_PAGE_SIZE = 1000;

    /**
     * Initializes a new instance of the {@link #PartnerServiceRequestCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public PartnerServiceRequestCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves a collection of operations that can be performed on support topics.
     * 
     * @return a collection of operations that can be performed on support topics.
     */
    @Override
    public ISupportTopicsCollectionOperations getSupportTopics()
    {
        return new SupportTopicsCollectionOperations( this.getPartner() );
    }

    /**
     * Retrieves a Service Request specified by Id.
     * 
     * @param serviceRequestId Incident Id.
     * @return Service Request Operations.
     */
    @Override
    public IServiceRequestOperations byId( String serviceRequestId )
    {
        return new PartnerServiceRequestOperations( this.getPartner(), serviceRequestId );
    }

    /**
     * Queries for service requests associated with the partner.
     * 
     * @param serviceRequestsQuery The query with search parameters.
     * @return A collection of service requests matching the criteria.
     */
    @Override
    public SeekBasedResourceCollection<ServiceRequest> query( IQuery serviceRequestsQuery )
    {
        if ( serviceRequestsQuery == null )
        {
            throw new IllegalArgumentException( "serviceRequestsQuery can't be null" );
        }

        if ( serviceRequestsQuery.getType() != QueryType.INDEXED && serviceRequestsQuery.getType() != QueryType.SIMPLE )
        {
            throw new IllegalArgumentException( "Specified query type is not supported." );
        }

        PartnerServiceProxy<ServiceRequest, SeekBasedResourceCollection<ServiceRequest>> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, SeekBasedResourceCollection<ServiceRequest>>( new TypeReference<SeekBasedResourceCollection<ServiceRequest>>()
            {
            }, this.getPartner(), MicrosoftPartnerSdk.getConfiguration().getApis().get( "SearchPartnerServiceRequests" ).getPath() );

        if ( serviceRequestsQuery.getType() == QueryType.INDEXED )
        {
            // if the query specifies a page size, validate it and add it to the request
            ParameterValidator.isIntInclusive( MIN_PAGE_SIZE, MAX_PAGE_SIZE, serviceRequestsQuery.getPageSize(),
                                               MessageFormat.format( "Allowed page size values are from {0}-{1}",
                                                                     MIN_PAGE_SIZE, MAX_PAGE_SIZE, Locale.US ) );
            partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "SearchPartnerServiceRequests" ).getParameters().get( "Size" ),
                                                                                          String.valueOf( serviceRequestsQuery.getPageSize() ) ) );
            partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "SearchPartnerServiceRequests" ).getParameters().get( "Offset" ),
                                                                                          String.valueOf( serviceRequestsQuery.getIndex() ) ) );
        }
        if ( serviceRequestsQuery.getFilter() != null )
        {
            // add the filter to the request if specified
            ObjectMapper mapper = new ObjectMapper();
            try
            {
                partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "SearchPartnerServiceRequests" ).getParameters().get( "Filter" ),
                                                                                              URLEncoder.encode( mapper.writeValueAsString( serviceRequestsQuery.getFilter() ),
                                                                                                                 "UTF-8" ) ) );
            }
            catch ( JsonProcessingException e )
            {
                throw new PartnerException( "", null, PartnerErrorCategory.REQUEST_PARSING, e );
            }
            catch ( UnsupportedEncodingException e )
            {
                throw new PartnerException( "", null, PartnerErrorCategory.REQUEST_PARSING, e );
            }

        }
        return partnerServiceProxy.get();
    }

    /**
     * Retrieves Service Requests associated to the partner.
     * 
     * @return A collection of service requests.
     */
    @Override
    public ResourceCollection<ServiceRequest> get()
    {
        IPartnerServiceProxy<ServiceRequest, ResourceCollection<ServiceRequest>> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, ResourceCollection<ServiceRequest>>( new TypeReference<ResourceCollection<ServiceRequest>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetAllServiceRequestsPartner" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Creates a service request.
     * 
     * @param serviceRequest Service request to be created.
     * @param agentLocale The agent locale.
     * @return The created service request with associated Identifier.
     */
    @Override
    public ServiceRequest create( ServiceRequest serviceRequest, String agentLocale )
    {
        if ( serviceRequest == null )
        {
            throw new IllegalArgumentException( "serviceRequest can't be null" );
        }
        if ( agentLocale == null )
        {
            throw new IllegalArgumentException( "agentLocale can't be null" );
        }
        IPartnerServiceProxy<ServiceRequest, ServiceRequest> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, ServiceRequest>( new TypeReference<ServiceRequest>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "CreateServiceRequest" ).getPath(),
                                                        ImplicitOrganizationId, Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "CreateServiceRequest" ).getParameters().get( "Locale" ),
                                                                                      agentLocale ) );

        return partnerServiceProxy.post( serviceRequest );
    }

}
