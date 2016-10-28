package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerSearchField;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.query.filters.FieldFilterOperation;
import com.microsoft.univstore.partnercentersdk.models.query.filters.SimpleFieldFilter;

public class CustomerFilteringIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PagedResourceCollection<Customer> customerCollection =
            partnerOperations.getCustomers().query( QueryFactory.buildSimpleQuery( new SimpleFieldFilter( CustomerSearchField.COMPANY_NAME.toString(),
                                                                                                          "A",
                                                                                                          FieldFilterOperation.STARTS_WITH ) ) );

        assertNotNull( customerCollection );
        assertTrue( customerCollection.getTotalCount() > 0 );
        
        for ( Customer customer : customerCollection.getItems() )
        {
            assertTrue( customer.getCompanyProfile().getCompanyName().charAt( 0 ) == 'a'
                || customer.getCompanyProfile().getCompanyName().charAt( 0 ) == 'A' );
        }
    }
}
