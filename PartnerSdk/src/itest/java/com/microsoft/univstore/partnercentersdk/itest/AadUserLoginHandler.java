package com.microsoft.univstore.partnercentersdk.itest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.joda.time.DateTime;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.univstore.partnercentersdk.core.AuthenticationToken;
import com.microsoft.univstore.partnercentersdk.core.IAadLoginHandler;

public class AadUserLoginHandler
    implements IAadLoginHandler
{

    /**
     * Logs into Azure active directory.
     * 
     * @return The authentication result.
     */
    @Override
    public AuthenticationToken authenticate()
    {
        // async
        // read AAD configuration
        String authority = ConfigurationHolder.getInstance().getConfiguration().get( "aad.authority" );
        String commonDomain = ConfigurationHolder.getInstance().getConfiguration().get( "aad.commonDomain" );
        String resourceUrl = ConfigurationHolder.getInstance().getConfiguration().get( "aad.resourceUrl" );
        String clientId = ConfigurationHolder.getInstance().getConfiguration().get( "aad.clientId" );
        String userName = ConfigurationHolder.getInstance().getConfiguration().get( "aad.userName" );
        String password = ConfigurationHolder.getInstance().getConfiguration().get( "aad.password" );

        AuthenticationContext context = null;
        AuthenticationResult result = null;
        ExecutorService service = null;
        try
        {
            URI addAuthority = new URI( authority ).resolve( new URI( commonDomain ) );

            service = Executors.newFixedThreadPool( 1 );
            context = new AuthenticationContext( addAuthority.toString(), false, service );
            context.setCorrelationId( UUID.randomUUID().toString() );
            Future<AuthenticationResult> future =
                context.acquireToken( resourceUrl, clientId, userName, password, null );
            result = future.get();
        }
        catch ( URISyntaxException e)
        {
            e.printStackTrace();
        }
        catch ( MalformedURLException e )
        {
            e.printStackTrace();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        catch ( ExecutionException e )
        {
            e.printStackTrace();
        }
        finally
        {
            service.shutdown();
        }

        // if ( result == null )
        // {
        // throw new ServiceUnavailableException( "authentication result was null" );
        // }
        return new AuthenticationToken( result.getAccessToken(),
                                 new DateTime( result.getExpiresOnDate() ) );

    }

}
