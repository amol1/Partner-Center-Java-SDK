package com.microsoft.univstore.partnercentersdk.samples.context;

import com.microsoft.univstore.partnercentersdk.core.IAadLoginHandler;
import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.extensions.PartnerCredentials;
import com.microsoft.univstore.partnercentersdk.samples.AadUserLoginHandler;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.configuration.Configuration;
import com.microsoft.univstore.partnercentersdk.samples.configuration.ConfigurationHolder;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="ScenarioContext.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Scenario context implementation class.
 */
public class ScenarioContext
    implements IScenarioContext
{
    /**
     * A lazy reference to an user based partner operations.
     */
    private IAggregatePartnerOperations userPartnerOperations = null;

    /**
     * A lazy reference to an application based partner operations.
     */
    private IAggregatePartnerOperations appPartnerOperations = null;

    /**
     * Initializes a new instance of the {@link #ScenarioContext} class.
     */
    public ScenarioContext()
    {
        MicrosoftPartnerSdk.setPartnerServiceApiRoot( ConfigurationHolder.getInstance().getConfiguration().getPartnerServiceSettings().get( "PartnerServiceApiEndpoint" ) );
        MicrosoftPartnerSdk.setProxyOptions( "localhost", 8888 );
    }

    /**
     * Gets a partner operations instance which is application based authenticated.
     */
    @Override
    public IAggregatePartnerOperations getAppPartnerOperations()
    {
        if ( this.appPartnerOperations == null )
        {
            System.out.println( "Authenticating application... " );
            IPartnerCredentials appCredentials =
                PartnerCredentials.generateByApplicationCredentials( ConfigurationHolder.getInstance().getConfiguration().getAppAuthentication().get( "ApplicationId" ),
                                                                     ConfigurationHolder.getInstance().getConfiguration().getAppAuthentication().get( "ApplicationSecret" ),
                                                                     ConfigurationHolder.getInstance().getConfiguration().getAppAuthentication().get( "Domain" ),
                                                                     ConfigurationHolder.getInstance().getConfiguration().getPartnerServiceSettings().get( "AuthenticationAuthorityEndpoint" ),
                                                                     ConfigurationHolder.getInstance().getConfiguration().getPartnerServiceSettings().get( "GraphEndpoint" ) );

            System.out.println( "Authenticated!" );
            this.appPartnerOperations = MicrosoftPartnerSdk.createPartnerOperations( appCredentials );
        }

        return this.appPartnerOperations;
    }

    /**
     * Gets a configuration instance.
     */
    @Override
    public Configuration getConfiguration()
    {
        return ConfigurationHolder.getInstance().getConfiguration();
    }

    /**
     * Gets a console helper instance.
     */
    @Override
    public ConsoleHelper getConsoleHelper()
    {
        return ConsoleHelper.getInstance();
    }

    /**
     * Gets a partner operations instance which is user based authenticated.
     */
    @Override
    public IAggregatePartnerOperations getUserPartnerOperations()
    {
        if ( this.userPartnerOperations == null )
        {
            System.out.println( "Authenticating user... " );
            // give the partner SDK the new add token information
            IAadLoginHandler loginHandler = new AadUserLoginHandler();
            IPartnerCredentials userCredentials =
                PartnerCredentials.generateByUserCredentials( this.getConfiguration().getUserAuthentication().get( "ClientId" ),
                                                              loginHandler.authenticate(), loginHandler );

            System.out.println( "Authenticated!" );
            this.userPartnerOperations = MicrosoftPartnerSdk.createPartnerOperations( userCredentials );
        }

        return this.userPartnerOperations;
    }

}
