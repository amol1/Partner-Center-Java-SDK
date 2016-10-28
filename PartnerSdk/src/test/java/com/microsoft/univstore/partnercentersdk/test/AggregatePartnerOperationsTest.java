package com.microsoft.univstore.partnercentersdk.test;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;

import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;

public class AggregatePartnerOperationsTest
{

    @Test
    public void VerifyScopedPartnerOperation()
    {
        IPartnerCredentials mockCredentials = Mockito.mock( IPartnerCredentials.class );
        IRequestContext expectedContext = RequestContextFactory.create();

        IAggregatePartnerOperations partnerOperations = MicrosoftPartnerSdk.createPartnerOperations( mockCredentials );
        IPartnerOperations scopedPartnerOperations = partnerOperations.with( expectedContext );

        // Assert, ensure that the partner operations maintain the credentials
        assertEquals( mockCredentials, partnerOperations.getCredentials() );

        // Ensure that there is not specific request id set as this is the global partner operations
        assertEquals( new UUID( 0, 0 ), partnerOperations.getRequestContext().getRequestId() );

        // Ensure that the scoped partner operations have the same credentials and the expected context
        assertEquals( mockCredentials, scopedPartnerOperations.getCredentials() );
        assertEquals( expectedContext, scopedPartnerOperations.getRequestContext() );
    }
}
