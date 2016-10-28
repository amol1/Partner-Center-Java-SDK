package com.microsoft.univstore.partnercentersdk.extensions;

import com.microsoft.univstore.partnercentersdk.core.AuthenticationToken;
import com.microsoft.univstore.partnercentersdk.core.IAadLoginHandler;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;

// -----------------------------------------------------------------------
// <copyright file="PartnerCredentials.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The third party partner credentials. Use to generate the credentials.
 */
public class PartnerCredentials
{
    /**
     * Generates partner credentials for third party applications using application credentials.
     *
     * @param clientId The client id of the application in azure active directory.
     * @param applicationSecret The application secret with azure active directory.
     * @param aadApplicationDomain The application domain in Azure Active Directory.
     * @return The partner service credentials.
     */
    public static IPartnerCredentials generateByApplicationCredentials( String clientId, String applicationSecret,
                                                                        String aadApplicationDomain )
    {
        return PartnerCredentials.generateByApplicationCredentials( clientId, applicationSecret, aadApplicationDomain,
                                                                    null );
    }

    public static IPartnerCredentials generateByApplicationCredentials( String clientId, String applicationSecret,
                                                                        String aadApplicationDomain,
                                                                        IRequestContext requestContext )
    {
        ApplicationPartnerCredentials partnerCredentials =
            new ApplicationPartnerCredentials( clientId, applicationSecret, aadApplicationDomain );
        partnerCredentials.authenticate( requestContext );

        return partnerCredentials;
    }

    /**
     * Generates partner credentials for third party applications using a user azure active directory token.
     * 
     * @param clientId The client id of the application in azure active directory.
     * @param authenticationToken The azure active directory token.
     * @param loginHandler An optional delegate which will be called when the azure active directory token expires and
     *            can no longer be used to generate the partner credentials. This delegate should return an up to date
     *            azure active directory token.
     * @return The partner service credentials.
     */
    public static IPartnerCredentials generateByUserCredentials( String clientId,
                                                                 AuthenticationToken authenticationToken,
                                                                 IAadLoginHandler loginHandler )
    {
        final UserPartnerCredentials partnerCredentials =
            new UserPartnerCredentials( clientId, authenticationToken, loginHandler );
        partnerCredentials.authenticate();
        return partnerCredentials;
    }

    /**
     * Generates partner credentials for third party applications using application credentials with the provided AAD
     * overrides.
     *
     * @param clientId The client id of the application in azure active directory.
     * @param applicationSecret The application secret with azure active directory.
     * @param aadApplicationDomain The application domain in Azure Active Directory.
     * @param aadAuthorityEndpoint The active directory authority endpoint.
     * @param graphEndpoint The AAD graph API endpoint.
     * @return The partner service credentials.
     */
    public static IPartnerCredentials generateByApplicationCredentials( String clientId, String applicationSecret,
                                                                        String aadApplicationDomain,
                                                                        String aadAuthorityEndpoint,
                                                                        String graphEndpoint )
    {
        return PartnerCredentials.generateByApplicationCredentials( clientId, applicationSecret, aadApplicationDomain,
                                                                    aadAuthorityEndpoint, graphEndpoint, null );
    }

    public static IPartnerCredentials generateByApplicationCredentials( String clientId, String applicationSecret,
                                                                        String aadApplicationDomain,
                                                                        String aadAuthorityEndpoint,
                                                                        String graphEndpoint,
                                                                        IRequestContext requestContext )
    {
        if ( StringHelper.isNullOrWhiteSpace( aadAuthorityEndpoint ) )
        {
            throw new IllegalArgumentException( "aadAuthorityEndpoint can't be empty" );
        }
        if ( StringHelper.isNullOrWhiteSpace( graphEndpoint ) )
        {
            throw new IllegalArgumentException( "graphEndpoint can't be empty" );
        }

        ApplicationPartnerCredentials partnerCredentials =
            new ApplicationPartnerCredentials( clientId, applicationSecret, aadApplicationDomain, aadAuthorityEndpoint,
                                               graphEndpoint );
        partnerCredentials.authenticate( requestContext );

        return partnerCredentials;
    }

}

// await