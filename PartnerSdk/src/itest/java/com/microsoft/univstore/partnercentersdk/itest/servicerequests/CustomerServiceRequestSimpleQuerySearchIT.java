package com.microsoft.univstore.partnercentersdk.itest.servicerequests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

public class CustomerServiceRequestSimpleQuerySearchIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( UUID.randomUUID() ) );

        ResourceCollection<Customer> customerCollection = partnerOperations.getCustomers().get();
        
        PagedResourceCollection<ServiceRequest> serviceRequestCollection = null;
        
        for (Customer customer : customerCollection.getItems())
        {
            PagedResourceCollection<ServiceRequest> serviceRequestCollectionTry =  partnerOperations.getCustomers().byId( customer.getId() ).getServiceRequests().query( QueryFactory.buildSimpleQuery() );
            if (serviceRequestCollectionTry.getTotalCount() > 0 )
            {
                serviceRequestCollection = serviceRequestCollectionTry;
                break;
            }
        }
        
        assertNotNull( serviceRequestCollection );
        assertTrue( serviceRequestCollection.getTotalCount() > 0 );
        assertNotNull( serviceRequestCollection.getItems().iterator().next() );

    }
}
