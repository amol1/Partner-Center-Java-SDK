package com.microsoft.univstore.partnercentersdk.itest.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;

public class CustomerHelper
{

    public static Customer getFirstCustomerFromPagedQuery(IPartnerOperations partnerOperations)
    {
        // read customers into chunks of 40s
        PagedResourceCollection<Customer> customers =
            partnerOperations.getCustomers().query( QueryFactory.buildIndexedQuery( 1 ) );

        return customers.getItems().iterator().next();
    }
}
