package com.microsoft.univstore.partnercentersdk.core.errorhandling;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerErrorCategory;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.core.logging.PartnerLog;
import com.microsoft.univstore.partnercentersdk.core.network.HttpStatusCode;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ApiFault;

// -----------------------------------------------------------------------
// <copyright file="DefaultPartnerServiceErrorHandler.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The default handling policy for failed partner service responses.
 */
public class DefaultPartnerServiceErrorHandler
    implements IFailedPartnerServiceResponseHandler
{
    /**
     * Handles failed partner service responses.
     * 
     * @param response The partner service response.
     * @param context An optional partner context.
     * @return The exception to throw.
     */
    @Override
    public PartnerException handleFailedResponse( HttpResponse response )
    {
        return handleFailedResponse( response, null );
    }

    @Override
    public PartnerException handleFailedResponse( HttpResponse response, IRequestContext context )
    {
        if ( response == null )
        {
            throw new IllegalArgumentException( "Response is null" );
        }

        if ( response.getStatusLine().getStatusCode() < 400 )
        {
            throw new IllegalArgumentException( "DefaultPartnerServiceErrorHandler: response is successful." );
        }

        String responsePayload;
        try
        {
            responsePayload = StringHelper.fromInputStream( response.getEntity().getContent(), "UTF-8" );
        }
        catch ( IOException e )
        {
            responsePayload = "";
        }
        ApiFault apiFault = null;
        PartnerException partnerException = null;

        // log the failed response
        PartnerLog.getInstance().logError( MessageFormat.format( "Partner service failed response:{0}", responsePayload,
                                                                 Locale.US ) );

        // attempt to deserialize the response into an ApiFault object as this is what the partner service is
        // expected to do when it errors out
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            apiFault = mapper.readValue( responsePayload, ApiFault.class );
        }
        catch ( IOException e )
        {
            // LogManager.Instance.Error( "Could not parse error response: " + deserializationProblem.toString() );
        }

        PartnerErrorCategory errorCategory;
        errorCategory = toPartnerErrorCategory( response.getStatusLine().getStatusCode() );
        partnerException = apiFault != null ? new PartnerException( apiFault, context, errorCategory )
                        : new PartnerException( StringHelper.isNullOrWhiteSpace( responsePayload )
                                        ? response.getStatusLine().getReasonPhrase() : responsePayload, context,
                                                errorCategory );

        return partnerException;
    }

    /**
     * Generates the partner error category based on the HTTP response code.
     * 
     * @param statusCode The HTTP response code.
     * @return The partner error category.
     */
    private static PartnerErrorCategory toPartnerErrorCategory( int statusCode )
    {
        PartnerErrorCategory errorCategory = PartnerErrorCategory.NOT_SPECIFIED;
        switch ( statusCode )
        {
            case HttpStatusCode.BadRequest:
                errorCategory = PartnerErrorCategory.BAD_INPUT;
                break;
            case HttpStatusCode.Unauthorized:
                errorCategory = PartnerErrorCategory.UNAUTHORIZED;
                break;
            case HttpStatusCode.Forbidden:
                errorCategory = PartnerErrorCategory.FORBIDDEN;
                break;
            case HttpStatusCode.NotFound:
                errorCategory = PartnerErrorCategory.NOT_FOUND;
                break;
            case HttpStatusCode.Conflict:
                errorCategory = PartnerErrorCategory.ALREADY_EXISTS;
                break;
            case HttpStatusCode.ServiceUnavailable:
                errorCategory = PartnerErrorCategory.SERVER_BUSY;
                break;
            default:
                errorCategory = PartnerErrorCategory.SERVER_ERROR;
                break;
        }
        return errorCategory;
    }

}
