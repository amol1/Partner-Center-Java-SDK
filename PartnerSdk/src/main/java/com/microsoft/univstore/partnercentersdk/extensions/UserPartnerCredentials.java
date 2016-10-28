package com.microsoft.univstore.partnercentersdk.extensions;

import com.microsoft.univstore.partnercentersdk.core.AuthenticationToken;
import com.microsoft.univstore.partnercentersdk.core.IAadLoginHandler;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerErrorCategory;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.core.logging.PartnerLog;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;

// -----------------------------------------------------------------------
// <copyright file="UserPartnerCredentials.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Partner service credentials based on azure active directory user credentials.
 */
public class UserPartnerCredentials
    extends BasePartnerCredentials
{
    /**
     * The delegate used to refresh the azure active directory token.
     */
    private final IAadLoginHandler tokenRefresher;

    /**
     * Initializes a new instance of the {@link #UserPartnerCredentials} class.
     * 
     * @param clientId The client id of the application in azure active directory.
     * @param aadAuthenticationToken The azure active directory token.
     * @param aadTokenRefresher An optional delegate which will be called when the azure active directory token expires
     *            and can no longer be used to generate the partner credentials. This delegate should return an up to
     *            date azure active directory token.
     */
    public UserPartnerCredentials( String clientId, AuthenticationToken aadAuthenticationToken )
    {
        this( clientId, aadAuthenticationToken, null );
    }

    public UserPartnerCredentials( String clientId, AuthenticationToken aadAuthenticationToken,
                                   IAadLoginHandler loginHandler )
    {
        super( clientId );
        if ( aadAuthenticationToken == null )
        {
            throw new IllegalArgumentException( "aadAuthenticationToken" );
        }
        else
        {
            if ( aadAuthenticationToken.isExpired() )
            {
                throw new IllegalArgumentException( "aadAuthenticationToken is expired." );
            }
        }
        this.setAADToken( aadAuthenticationToken );
        this.tokenRefresher = loginHandler;
        MicrosoftPartnerSdk.setRefreshCredentialsHandler( this );
    }

    /**
     * Called when a partner credentials instance needs to be refreshed.
     *
     * @param credentials The outdated partner credentials.
     * @param context The partner context.
     * @return A task that is complete when the credential refresh is done.
     */
    @Override
    public void onCredentialsRefreshNeeded( IPartnerCredentials credentials, IRequestContext context )
    {
        UserPartnerCredentials partnerCredentials = (UserPartnerCredentials) credentials;
        if ( partnerCredentials != null )
        {
            // we can deal with the partner credentials object, refresh it
            partnerCredentials.refresh( context );
        }
        else
        {
            PartnerLog.getInstance().logWarning( UserPartnerCredentials.class
                + ": The given credentials are not supported." );
        }
    }

    /**
     * Refreshes the partner credentials.
     *
     * @param context The partner context.
     * @return A task which is complete when the refresh is done.
     */
    private void refresh( IRequestContext context )
    {
        // async
        if ( this.getAADToken().isExpired() )
        {
            // we need to refresh the AAD before attempting to re-authenticate with the partner service
            if ( this.tokenRefresher != null )
            {
                // invoke the callback and let it provide us with the new aad token
                AuthenticationToken newAadToken = tokenRefresher.authenticate();

                if ( newAadToken == null )
                {
                    String errorMessage = "Token refresher returned null token.";
                    PartnerLog.getInstance().logError( errorMessage );
                    throw new PartnerException( errorMessage, context, PartnerErrorCategory.UNAUTHORIZED );
                }

                if ( newAadToken.isExpired() )
                {
                    String errorMessage = "Token refresher returned an expired token.";
                    PartnerLog.getInstance().logError( errorMessage );
                    throw new PartnerException( errorMessage, context, PartnerErrorCategory.UNAUTHORIZED );
                }

                setAADToken( newAadToken );

            }
            else
            {
                String errorMessage = "AAD Token needs refreshing but no handler was registered.";
                PartnerLog.getInstance().logWarning( errorMessage );
                throw new PartnerException( errorMessage, context, PartnerErrorCategory.UNAUTHORIZED );
            }
        }
        // get a new partner service token using the AAD token we have
        this.authenticate();
    }

}