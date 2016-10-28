package com.microsoft.univstore.partnercentersdk.itest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;

public class ConfigurationHolder
{
    public static Map<String, String> configuration; 
    
    private static ConfigurationHolder instance;
    
    @SuppressWarnings( "unchecked" )
    private ConfigurationHolder() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is =
            MicrosoftPartnerSdk.class.getClassLoader().getResourceAsStream( "TestConfiguration.json" );
        try
        {
            configuration = mapper.readValue( is, Map.class );
        }
        catch ( IOException e )
        {
            throw new PartnerException( "Problem reading PartnerSDK test configuration file", e );
        }
    }
    
    public static ConfigurationHolder getInstance() {
        if (instance == null) 
        {
            instance = new ConfigurationHolder();
        }
        return instance;
    }
    
    public Map<String,String> getConfiguration() 
    {
        return configuration;
    }
    

}
