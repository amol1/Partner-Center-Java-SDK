package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;

public class CustomerPagingIT
{

    @Test
    public void test()
    {
        IAggregatePartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        // read customers into chunks of 40s
        PagedResourceCollection<Customer> customersBatch =
            partnerOperations.getCustomers().query( QueryFactory.buildIndexedQuery( 40 ) );

        IResourceCollectionEnumerator<PagedResourceCollection<Customer>> customersEnumerator =
            partnerOperations.getEnumerators().getCustomers().create( customersBatch );
     
        while (customersEnumerator.hasValue())
        {
            assertTrue( customersEnumerator.getCurrent().getTotalCount() > 0 );
            assertTrue( customersEnumerator.getCurrent().getTotalCount() <= 40 );
            assertNotNull(customersEnumerator.getCurrent().getItems().iterator().next());
            
            customersEnumerator.next();
        }

    }

}
