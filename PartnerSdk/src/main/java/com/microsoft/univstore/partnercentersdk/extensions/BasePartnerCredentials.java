package com.microsoft.univstore.partnercentersdk.extensions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.AuthenticationToken;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.errorhandling.DefaultPartnerServiceErrorHandler;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerErrorCategory;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.core.logging.PartnerLog;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;

// -----------------------------------------------------------------------
// <copyright file="BasePartnerCredentials.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A base implementation for partner credentials.
 */
public abstract class BasePartnerCredentials
    implements IPartnerCredentials
{
    /**
     * The JWT token needed to authenticate with the partner service.
     */
    private AuthenticationToken jwtToken;

    /**
     * Initializes a new instance of the {@link #BasePartnerCredentials} class.
     * 
     * @param clientId The azure active directory client Id.
     */
    public BasePartnerCredentials( String clientId )
    {
        if ( StringHelper.isNullOrWhiteSpace( clientId ) )
        {
            throw new IllegalArgumentException( "clientId has to be set" );
        }

        this.setClientId( clientId );
    }

    /**
     * Gets the partner service token.
     */
    @Override
    public String getPartnerServiceToken()
    {
        return this.jwtToken.getToken();
    }

    /**
     * Gets the expiry time in UTC for the token.
     */
    @Override
    public DateTime getExpiresAt()
    {
        return this.jwtToken.getExpiryTime();
    }

    /**
     * Gets or sets the azure active directory token.
     */
    private AuthenticationToken __AADToken;

    protected AuthenticationToken getAADToken()
    {
        return __AADToken;
    }

    protected void setAADToken( AuthenticationToken value )
    {
        __AADToken = value;
    }

    /**
     * Gets the azure active directory client Id.
     */
    private String __ClientId = new String();

    protected String getClientId()
    {
        return __ClientId;
    }

    protected void setClientId( String value )
    {
        __ClientId = value;
    }

    /**
     * Indicates whether the partner credentials have expired or not.
     * 
     * @return True if credentials have expired. False if not.
     */
    @Override
    public boolean isExpired()
    {
        return this.jwtToken.isExpired();
    }

    /**
     * Authenticates with the partner service.
     * 
     * @return A task that is complete when authentication is finished.
     */
    public void authenticate()
    {
        authenticate( null );
    }

    @SuppressWarnings( "unchecked" )
    public void authenticate( IRequestContext requestContext )
    {
        HttpClientBuilder builder = HttpClients.custom().disableContentCompression();
        String proxyName = MicrosoftPartnerSdk.getProxyHostName();
        Integer proxyPort = MicrosoftPartnerSdk.getProxyPort();
        if (proxyName != null && proxyPort != null)
        {
            builder = builder.setProxy( new HttpHost( proxyName, proxyPort ) );
        }
        CloseableHttpClient httpClient = builder.build();

        // send a generate token request to the service
        HttpPost httpPost = new HttpPost( MicrosoftPartnerSdk.getPartnerServiceApiRoot() + "/GenerateToken" );
        httpPost.setHeader( "Authorization", "Bearer " + getAADToken().getToken() );

        if ( requestContext != null )
        {
            if ( requestContext.getCorrelationId().equals( new UUID( 0, 0 ) ) )
            {
                httpPost.setHeader( "MS-CorrelationId", requestContext.getCorrelationId().toString() );
            }
            if ( requestContext.getRequestId().equals( new UUID( 0, 0 ) ) )
            {
                httpPost.setHeader( "MS-RequestId", requestContext.getRequestId().toString() );
            }
            if ( !StringHelper.isNullOrWhiteSpace( requestContext.getLocale() ) )
            {
                httpPost.setHeader( "X-Locale", requestContext.getLocale() );
            }
        }

        List<NameValuePair> formContent = new ArrayList<NameValuePair>();
        formContent.add( new BasicNameValuePair( "grant_type", "jwt_token" ) );
        formContent.add( new BasicNameValuePair( "client_id", getClientId() ) );
        try
        {
            httpPost.setEntity( new UrlEncodedFormEntity( formContent ) );
        }
        catch ( UnsupportedEncodingException e )
        {
            throw new PartnerException( "Error setting the http headers for the API authentication", e );
        }
        HttpResponse response;
        try
        {
            response = httpClient.execute( httpPost );
        }
        catch ( IOException e )
        {
            throw new PartnerException( "Error making the http request for the API authentication", e );
        }

        if ( response.getStatusLine().getStatusCode() == 200 )
        {
            // try reading the JWT from the response
            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> authenticationResult;
            try
            {
                authenticationResult = mapper.readValue( response.getEntity().getContent(), Map.class );
            }
            catch ( IOException e )
            {
                String errorMessage = "Couldn't parse the token exchange response.";
                PartnerLog.getInstance().logError( errorMessage );
                throw new PartnerException( errorMessage, null, PartnerErrorCategory.RESPONSE_PARSING, e );
            }
            String jwtToken = (String) authenticationResult.get( "access_token" );
            Integer expiryTime = (Integer) authenticationResult.get( "expires_in" );

            if ( jwtToken != null && expiryTime != null )
            {
                int expiresInSeconds = expiryTime;

                this.jwtToken = new AuthenticationToken( jwtToken, DateTime.now().plusSeconds( expiresInSeconds ) );

            }
            else
            {
                String errorMessage = "Failed to read the access token from partner service authentication response.";
                PartnerLog.getInstance().logError( errorMessage );

                if ( jwtToken == null )
                {
                    PartnerLog.getInstance().logError( "jwtToken is null" );
                }
                if ( expiryTime == null )
                {
                    PartnerLog.getInstance().logError( "expiryTime is null" );
                }
                throw new PartnerException( errorMessage, null, PartnerErrorCategory.UNAUTHORIZED );
            }
        }
        else
        {
            throw new DefaultPartnerServiceErrorHandler().handleFailedResponse( response );
        }

        try
        {
            httpClient.close();
        }
        catch ( IOException e )
        {
            throw new PartnerException( "Couldn't close the http connection", e );
        }
    }
}

// await