package com.microsoft.univstore.partnercentersdk.itest.profiles;

import static org.junit.Assert.*;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;

public class UpdateCustomerBillingProfileIT
{

    @Test
    public void test()
    {

        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery( partnerOperations );

        CustomerBillingProfile billingProfile =
            partnerOperations.getCustomers().byId( customer.getId() ).getProfiles().getBilling().get();

        String expectedFirstName = billingProfile.getFirstName() + "J";
        String expectedLastName = billingProfile.getLastName() + "J";
        String expectedCompanyName = billingProfile.getCompanyName() + "J";
        billingProfile.setFirstName( expectedFirstName );
        billingProfile.setLastName(expectedLastName );
        billingProfile.setCompanyName( expectedCompanyName );

        CustomerBillingProfile updatedBillingProfile =
            partnerOperations.getCustomers().byId( customer.getId() ).getProfiles().getBilling().update( billingProfile );
        
        assertNotNull(updatedBillingProfile);
        assertEquals(expectedFirstName, updatedBillingProfile.getFirstName());
        assertEquals(expectedLastName, updatedBillingProfile.getLastName());
        assertEquals(expectedCompanyName, updatedBillingProfile.getCompanyName());

    }

}
