package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerCompanyProfile;

public class GetCustomerCompnayProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);
        
        CustomerCompanyProfile companyProfile =
                        partnerOperations.getCustomers().byId( customer.getId() ).getProfiles().getCompany().get();

        assertNotNull( companyProfile );  
        assertNotNull( companyProfile.getAttributes() );  
        // assertNotNull(companyProfile.getAttributes().getEtag());
        assertNotNull(companyProfile.getAttributes().getObjectType());
        assertNotNull(companyProfile.getCompanyName());
        assertNotNull(companyProfile.getDomain());   
        assertNotNull( companyProfile.getLinks() );       
        assertNotNull(companyProfile.getLinks().getSelf());
        assertNotNull(companyProfile.getTenantId());
    }
}
