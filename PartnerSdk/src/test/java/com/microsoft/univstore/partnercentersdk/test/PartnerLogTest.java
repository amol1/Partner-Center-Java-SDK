package com.microsoft.univstore.partnercentersdk.test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.logging.ILogger;
import com.microsoft.univstore.partnercentersdk.core.logging.PartnerLog;

public class PartnerLogTest
{

    private final String informationText = "Sample info";

    private final String warningText = "Sample warning";

    private final String errorText = "Sample error";

    private ILogger mockLogger1 = mock( ILogger.class );

    private ILogger mockLogger2 = mock( ILogger.class );

    @Before
    public void setup()
    {
        PartnerLog.getInstance().getLoggers().clear();
    }

    @Test
    public void verifyEmptyStringLogging()
    {
        PartnerLog.getInstance().getLoggers().add( mockLogger1 );

        injectMessages( "A" );

        injectInvalidMessages();

        verifyTotalNumberOfLoggedMessages( mockLogger1, 1 );
        verifyNumberOfLoggedMessages( mockLogger1, "A", 1 );
    }

    @Test
    public void verifyPropagationOfDifferentMessages()
    {
        PartnerLog.getInstance().getLoggers().add( mockLogger1 );

        verifyTotalNumberOfLoggedMessages( mockLogger1, 0 );

        injectMessages( "A" );
        verifyTotalNumberOfLoggedMessages( mockLogger1, 1 );
        verifyNumberOfLoggedMessages( mockLogger1, "A", 1 );

        injectMessages( "B" );
        verifyTotalNumberOfLoggedMessages( mockLogger1, 2 );
        verifyNumberOfLoggedMessages( mockLogger1, "B", 1 );
        verifyNumberOfLoggedMessages( mockLogger1, "A", 1 );
    }

    @Test
    public void verifyLoggerRemoval()
    {
        PartnerLog.getInstance().getLoggers().add( mockLogger1 );

        verifyTotalNumberOfLoggedMessages( mockLogger1, 0 );
        
        injectMessages( "A" );

        verifyTotalNumberOfLoggedMessages( mockLogger1, 1 );
        verifyNumberOfLoggedMessages( mockLogger1, "A", 1 );

        PartnerLog.getInstance().getLoggers().remove( mockLogger1 );

        injectMessages( "B" );

        verifyTotalNumberOfLoggedMessages( mockLogger1, 1 );
        verifyNumberOfLoggedMessages( mockLogger1, "B", 0 );        
    }
    
    @Test
    public void verifyMultipleLoggers() {
        PartnerLog.getInstance().getLoggers().add( mockLogger1 );
        PartnerLog.getInstance().getLoggers().add( mockLogger2 );
        
        injectMessages( "A" );
        injectMessages( "B" );

        verifyTotalNumberOfLoggedMessages( mockLogger1, 2 );
        verifyNumberOfLoggedMessages( mockLogger1, "A", 1 );
        verifyNumberOfLoggedMessages( mockLogger1, "B", 1 );
        
        verifyTotalNumberOfLoggedMessages( mockLogger2, 2 );
        verifyNumberOfLoggedMessages( mockLogger2, "A", 1 );
        verifyNumberOfLoggedMessages( mockLogger2, "B", 1 );        
    }

    private void verifyNumberOfLoggedMessages( ILogger mockLogger, String string, int count )
    {
        verify( mockLogger, times( count ) ).logInformation( buildInfoLogMessage( string ) );
        verify( mockLogger, times( count ) ).logWarning( buildWarningLogMessage( string ) );
        verify( mockLogger, times( count ) ).logError( buildErrorLogMessage( string ) );
    }

    private void verifyTotalNumberOfLoggedMessages( ILogger mockLogger, int count )
    {
        verify( mockLogger, times( count ) ).logInformation( anyString() );
        verify( mockLogger, times( count ) ).logWarning( anyString() );
        verify( mockLogger, times( count ) ).logError( anyString() );
    }

    private String buildInfoLogMessage( String suffix )
    {
        return informationText + suffix;
    }

    private String buildWarningLogMessage( String suffix )
    {
        return warningText + suffix;
    }

    private String buildErrorLogMessage( String suffix )
    {
        return errorText + suffix;
    }

    private void injectMessages( String message )
    {
        PartnerLog.getInstance().logInformation( buildInfoLogMessage( message ) );
        PartnerLog.getInstance().logWarning( buildWarningLogMessage( message ) );
        PartnerLog.getInstance().logError( buildErrorLogMessage( message ) );
    }

    private void injectInvalidMessages()
    {
        PartnerLog.getInstance().logInformation( null );
        PartnerLog.getInstance().logInformation( "" );
        PartnerLog.getInstance().logWarning( null );
        PartnerLog.getInstance().logWarning( "" );
        PartnerLog.getInstance().logError( null );
        PartnerLog.getInstance().logError( "" );

    }

}
