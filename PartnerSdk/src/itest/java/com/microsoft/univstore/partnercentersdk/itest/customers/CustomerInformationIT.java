package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;

public class CustomerInformationIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);

        Customer customerInfo = partnerOperations.getCustomers().byId( customer.getId() ).get();

        assertNotNull( customerInfo);
        assertNotNull( customerInfo.getAllowDelegatedAccess() );
        assertNotNull( customerInfo.getAttributes());
        // assertNotNull( customerInfo.getAttributes().getEtag() );
        assertNotNull( customerInfo.getAttributes().getObjectType() );
        assertNotNull( customerInfo.getBillingProfile() );
        assertNotNull( customerInfo.getCommerceId() );
        assertNotNull( customerInfo.getCompanyProfile() );
        assertNotNull( customerInfo.getId() );
        assertNotNull( customerInfo.getLinks());
        assertNotNull( customerInfo.getLinks().getSelf() );
        assertNotNull( customerInfo.getRelationshipToPartner() );
    }
}
