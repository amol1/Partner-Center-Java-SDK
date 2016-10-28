package com.microsoft.univstore.partnercentersdk.itest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.IAadLoginHandler;
import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.extensions.PartnerCredentials;
import com.microsoft.univstore.partnercentersdk.itest.ConfigurationHolder;

public class CredentialsHelper
{
    private IPartnerCredentials credentials;
    
    private static Map<String, String> configuration;

    public Map<String, String> getConfiguration()
    {
        return configuration;
    }

    public CredentialsHelper()
    {
        configuration = readConfiguration();
        MicrosoftPartnerSdk.setPartnerServiceApiRoot( ConfigurationHolder.getInstance().getConfiguration().get( "partnerServiceApiRoot" ) );
        MicrosoftPartnerSdk.setProxyOptions( "localhost", 8888 );
        credentials = authenticate();
    }
    
    public IAggregatePartnerOperations getPartnerOperations() {
        return MicrosoftPartnerSdk.createPartnerOperations( credentials );
    }

    @SuppressWarnings( "unchecked" )
    private Map<String, String> readConfiguration()
    {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is =
            MicrosoftPartnerSdk.class.getClassLoader().getResourceAsStream( "TestConfiguration.json" );
        try
        {
            return mapper.readValue( is, Map.class );
        }
        catch ( IOException e )
        {
            throw new PartnerException( "Problem reading PartnerSDK test configuration file", e );
        }
    }
    
    /**
     * Authenticates with the partner API service.
     * 
     * @return The service credentials.
     */
    private IPartnerCredentials authenticate()

    {
        IPartnerCredentials credentials = null;
        boolean isApplicationSignInEnabled = false; // boolean.Parse(ConfigurationManager.getAppSettings()["applicationSignIn"]);
        if ( isApplicationSignInEnabled )
        {
            // // This is an application sign in
            // String aadAuthority = ConfigurationManager.getAppSettings()["aad.authority"];
            // String graphEndpoint = ConfigurationManager.getAppSettings()["aad.graphEndpoint"];
            // String applicationId = ConfigurationManager.getAppSettings()["aad.applicationId"];
            // String applicationSecret = ConfigurationManager.getAppSettings()["aad.applicationSecret"];
            // String applicationDomain = ConfigurationManager.getAppSettings()["aad.applicationDomain"];
            // credentials = PartnerCredentials.GenerateByApplicationCredentials(applicationId, applicationSecret,
            // applicationDomain, aadAuthority, graphEndpoint);
            // // applications can't query customers, therefore let's set a default customer Id for the other features
            // to work
            // FeatureSamplesApplication.applicationState.put(FeatureSamplesApplication.SelectedCustomerKey, new
            // Customer());
        }
        else
        {
            IAadLoginHandler loginHandler = new AadUserLoginHandler();
            credentials = PartnerCredentials.generateByUserCredentials( ConfigurationHolder.getInstance().getConfiguration().get("aad.clientId"),
                                                                        loginHandler.authenticate(), loginHandler

            );
        }
        return credentials;
    }
}
