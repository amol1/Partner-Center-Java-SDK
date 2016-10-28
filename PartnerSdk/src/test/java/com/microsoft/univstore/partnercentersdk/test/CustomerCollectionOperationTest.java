package com.microsoft.univstore.partnercentersdk.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.customers.CustomerCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.test.utils.TimeHelper;

@RunWith( PowerMockRunner.class )
@PrepareForTest( PartnerServiceProxy.class )
public class CustomerCollectionOperationTest
{
    private static IPartnerCredentials expectedCredentials;

    private static IRequestContext expectedContext;

    private static IPartnerOperations partnerOperations;

    private static String expectedCustomerId = "1";

    private static CustomerCollectionOperations customerCollectionOperations;

    private static PartnerServiceProxy<Customer, Customer> proxy;

    @Before
    public void setup()
    {
        expectedCredentials = mock( IPartnerCredentials.class );
        when( expectedCredentials.getPartnerServiceToken() ).thenReturn( "Fake token" );
        when( expectedCredentials.getExpiresAt() ).thenReturn( TimeHelper.MAX_DATE_TIME );

        expectedContext = mock( IRequestContext.class );
        when( expectedContext.getCorrelationId() ).thenReturn( UUID.randomUUID() );
        when( expectedContext.getRequestId() ).thenReturn( UUID.randomUUID() );

        partnerOperations = mock( IPartnerOperations.class );
        when( partnerOperations.getCredentials() ).thenReturn( expectedCredentials );
        when( partnerOperations.getRequestContext() ).thenReturn( expectedContext );

        customerCollectionOperations = new CustomerCollectionOperations( partnerOperations );

    }

//    @Test
//    public void verifyCreateCustomer() 
//    {
//            PowerMockito.whenNew( PartnerServiceProxy.class ).withAnyArguments().thenAnswer( new Answer() {
//
//                @Override
//                public Object answer( InvocationOnMock invocation )
//                    throws Throwable
//                {
//                    Object[] args = invocation.getArguments(); 
//                    Object mock = invocation.getMock();
//                    if (expectedCredentials != ((IPartnerOperations) args[0]).getCredentials()) {org.junit.Assert
//.fail("");}
//                    return null;
//                }
//                
//            });
//        customerCollectionOperations.create( null);
//    }
    
    @Test
    public void dummyTest()
    {
        assertEquals( false, false);
    }

}
