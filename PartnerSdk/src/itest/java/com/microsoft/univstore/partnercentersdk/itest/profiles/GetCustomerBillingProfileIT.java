package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;

public class GetCustomerBillingProfileIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);
        
        CustomerBillingProfile billingProfile =
                        partnerOperations.getCustomers().byId( customer.getId() ).getProfiles().getBilling().get();

        assertNotNull( billingProfile );  
        assertNotNull( billingProfile.getAttributes() );  
        assertNotNull(billingProfile.getAttributes().getEtag());
        assertNotNull(billingProfile.getAttributes().getObjectType());
        assertNotNull(billingProfile.getCompanyName());
        assertNotNull(billingProfile.getCulture());
        assertNotNull( billingProfile.getDefaultAddress() );  
        assertNotNull(billingProfile.getDefaultAddress().getAddressLine1());
        //assertNotNull(billingProfile.getDefaultAddress().getAddressLine2());
        assertNotNull(billingProfile.getDefaultAddress().getCity());
        assertNotNull(billingProfile.getDefaultAddress().getCountry());
        assertNotNull(billingProfile.getDefaultAddress().getFirstName());
        assertNotNull(billingProfile.getDefaultAddress().getLastName());
        assertNotNull(billingProfile.getDefaultAddress().getPhoneNumber());
        assertNotNull(billingProfile.getDefaultAddress().getPostalCode());
        //assertNotNull(billingProfile.getDefaultAddress().getRegion());
        assertNotNull(billingProfile.getDefaultAddress().getState());
        assertNotNull(billingProfile.getEmail());
        assertNotNull(billingProfile.getFirstName());
        assertNotNull(billingProfile.getId());
        assertNotNull(billingProfile.getLanguage());
        assertNotNull(billingProfile.getLastName());
        assertNotNull( billingProfile.getLinks() );  
        assertNotNull(billingProfile.getLinks().getSelf());
    }
}
