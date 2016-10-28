package com.microsoft.univstore.partnercentersdk.core;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.configuration.Configuration;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.core.factory.IPartnerFactory;
import com.microsoft.univstore.partnercentersdk.core.factory.StandardPartnerFactory;
import com.microsoft.univstore.partnercentersdk.core.logging.PartnerLog;
import com.microsoft.univstore.partnercentersdk.core.logging.SystemOutLogger;
import com.microsoft.univstore.partnercentersdk.core.retries.ExponentialBackOffRetryPolicy;
import com.microsoft.univstore.partnercentersdk.core.retries.IRetryPolicy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;

// -----------------------------------------------------------------------
// <copyright file="MicrosoftPartnerSdk.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class contains the partner SDK properties and acts as the main entry point to create partners.
 */
public class MicrosoftPartnerSdk
{
    private static String __PartnerServiceApiRoot;

    public static String getPartnerServiceApiRoot()
    {
        return __PartnerServiceApiRoot;
    }

    public static void setPartnerServiceApiRoot( String value )
    {
        __PartnerServiceApiRoot = value;
    }

    private static String __PartnerServiceApiVersion;

    public static String getPartnerServiceApiVersion()
    {
        return __PartnerServiceApiVersion;
    }

    private static void setPartnerServiceApiVersion( String value )
    {
        __PartnerServiceApiVersion = value;
    }

    private static String __ApplicationName;

    public static String getApplicationName()
    {
        return __ApplicationName;
    }

    private static void setApplicationName( String value )
    {
    	__ApplicationName = value;
    }

    private static Configuration __Configuration;

    public static Configuration getConfiguration()
    {
        return __Configuration;
    }

    private static void setConfiguration( Configuration value )
    {
        __Configuration = value;
    }

    private static IPartnerFactory __Factory;

    public static IPartnerFactory getFactory()
    {
        return __Factory;
    }

    static void setFactory( IPartnerFactory value )
    {
        __Factory = value;
    }

    private static IPartnerCredentials refreshCredentialsHandler;

    public static IPartnerCredentials getRefreshCredentialsHandler()
    {
        return refreshCredentialsHandler;
    }

    public static void setRefreshCredentialsHandler( IPartnerCredentials partnerCredentials )
    {
        MicrosoftPartnerSdk.refreshCredentialsHandler = partnerCredentials;
    }

    /**
     * Gets the default retry policy used by the partner SDK.
     */
    private static IRetryPolicy __RetryPolicy;

    public static IRetryPolicy getRetryPolicy()
    {
        return __RetryPolicy;
    }

    public static void setRetryPolicy( IRetryPolicy value )
    {
        __RetryPolicy = value;
    }
    
    private static String proxyHostName;
    
    public static String getProxyHostName()
    {
        return proxyHostName;
    }
    
    private static Integer proxyPort;
    
    public static Integer getProxyPort()
    {
        return proxyPort;
    }
    
    public static void setProxyOptions(String hostName, Integer port)
    {
        if (StringHelper.isNullOrWhiteSpace( hostName ))
        {
            throw new PartnerException("The hostName should be set");
        }
        proxyHostName = hostName;
        proxyPort = port;
    }
    
    public static void clearProxyOptions()
    {
        proxyHostName = null;
        proxyPort = null;
    }

    static
    {
        /**
         * Initializes static members of the {@link #MicrosoftPartnerSdk} class.
         */
        setConfiguration( readPartnerSdkConfiguration() );
        // set the global partner service properties, for now we point to Krishna's server
        setPartnerServiceApiRoot( __Configuration.getPartnerServiceApiRoot() );
        setPartnerServiceApiVersion( __Configuration.getPartnerServiceApiVersion() );
        // initialize the partner factory
        setFactory( new StandardPartnerFactory() );
        // define the default retry policy as exponential with 3 retry attempts
        setRetryPolicy( new ExponentialBackOffRetryPolicy( getConfiguration().getDefaultMaxRetryAttempts() ) );
        // log to the debugger window
        PartnerLog.getInstance().getLoggers().add( new SystemOutLogger() );

    }

    /**
     * Creates a {@link #IPartnerOperations} instance and configures it using the provided partner credentials.
     * 
     * @param credentials The partner credentials. Use the {@link #IPartnerCredentials} class to obtain these.
     * @return A configured partner operations object.
     */
    public static IAggregatePartnerOperations createPartnerOperations( IPartnerCredentials credentials )
    {
        return getFactory().build( credentials );
    }
    
    /**
     * Reads the partner SDK configuration from the embedded resource file and massages its fields to be easily
     * accessible.
     * 
     * @return The partner SDK configuration.
     */
    private static Configuration readPartnerSdkConfiguration()
    {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is =
            MicrosoftPartnerSdk.class.getClassLoader().getResourceAsStream( "PartnerSdkConfiguration.json" );
        try
        {
            return mapper.readValue( is, Configuration.class );
        }
        catch ( IOException e )
        {
            throw new PartnerException( "Problem reading PartnerSDK configuration file", e );
        }
    }
}
