package com.microsoft.univstore.partnercentersdk.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

public class PartnerServiceProxyTest
{

    private static IRequestContext expectedContext;

    private static String expectedsuccessJsonHttpResponse;

    private static String expectedsuccessStringHttpResponse;

    private static Subscription expectedSubscription;

    private static IPartnerCredentials credentialsMock;

    private static HttpClient httpClientMock;

    private static PartnerServiceProxy<String, Subscription> proxyMock;

    private int refreshCredentialsCallbackInvocationCount;

    @BeforeClass
    public static void classSetup()
        throws JsonProcessingException
    {
        expectedSubscription = new Subscription();
        expectedSubscription.setId( "1" );
        expectedSubscription.setQuantity( 7 );
        expectedSubscription.setFriendlyName( "Sample subscription" );

        ObjectMapper mapper = new ObjectMapper();
        expectedsuccessJsonHttpResponse = mapper.writeValueAsString( expectedSubscription );
        expectedsuccessStringHttpResponse = "Some non-structured text";
        expectedContext = RequestContextFactory.create( UUID.randomUUID(), UUID.randomUUID(), "ru-RU" );
    }

    @SuppressWarnings( "unchecked" )
    @Before
    public void setup() {
        refreshCredentialsCallbackInvocationCount = 0;
        
        credentialsMock = mock(IPartnerCredentials.class);
        expectedContext = mock(IRequestContext.class);
        
        proxyMock = mock(PartnerServiceProxy.class);
        
                        
        
        IPartnerOperations partnerOperations = mock(IPartnerOperations.class);
        when (partnerOperations.getCredentials()).thenReturn( credentialsMock );
        
    }

    private void resetMockProxyHttpClient()
    {
        // TODO Auto-generated method stub

    }

    @Test
    public void test()
    {
        assertEquals( false, false );
    }

}
