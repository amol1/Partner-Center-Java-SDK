package com.microsoft.univstore.partnercentersdk.samples.configuration;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.samples.Program;

public class ConfigurationHolder
{
    public static Configuration configuration;

    private static ConfigurationHolder instance;

    private ConfigurationHolder()
    {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Program.class.getClassLoader().getResourceAsStream( "SamplesConfiguration.json" );
        // System.out.println( StringHelper.fromInputStream(is, "UTF-8") );
        try
        {
            configuration = mapper.readValue( is, Configuration.class );
        }
        catch ( IOException e )
        {
            throw new PartnerException( "Problem reading PartnerSDK Samples configuration file", e );
        }
    }

    public static ConfigurationHolder getInstance()
    {
        if ( instance == null )
        {
            instance = new ConfigurationHolder();
        }
        return instance;
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }

}
