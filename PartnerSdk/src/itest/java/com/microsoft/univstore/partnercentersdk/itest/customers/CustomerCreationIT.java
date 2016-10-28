package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.Address;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerCompanyProfile;

public class CustomerCreationIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        String expectedFirstName = "Engineer";
        String expectedLastName = "In Test";
        String expectedAddressLine1 = "4001 156th Ave";
        String expectedCity = "Redmond";
        String expectedState = "WA";
        String expectedCountry = "US";
        String expectedPostalCode = "98052";
        String expectedPhoneNumber = "4257778899";

        String expectedCulture = "en-US";
        String expectedEmail = "SomeEmail@MS.com";
        String expectedLanguage = "En";
        String expectedCompanyName = "Some Company" + new Random().nextInt();

        String expectedDomain = "SampleApplication" + Math.abs( new Random().nextInt() ) + ".ccsctp.net";

        Address address = new Address();
        address.setFirstName( expectedFirstName );
        address.setLastName( expectedLastName );
        address.setAddressLine1( expectedAddressLine1 );
        address.setCity( expectedCity );
        address.setState( expectedState );
        address.setCountry( expectedCountry );
        address.setPostalCode( expectedPostalCode );
        address.setPhoneNumber( expectedPhoneNumber );

        CustomerBillingProfile billingProfile = new CustomerBillingProfile();
        billingProfile.setCulture( expectedCulture );
        billingProfile.setEmail( expectedEmail );
        billingProfile.setLanguage( expectedLanguage );
        billingProfile.setCompanyName( expectedCompanyName );
        billingProfile.setDefaultAddress( address );

        CustomerCompanyProfile companyProfile = new CustomerCompanyProfile();
        companyProfile.setDomain( expectedDomain );

        Customer newCustomer = new Customer();
        newCustomer.setBillingProfile( billingProfile );
        newCustomer.setCompanyProfile( companyProfile );

        Customer createdCustomer = partnerOperations.getCustomers().create( newCustomer );

        assertNotNull( createdCustomer );
        //assertNotNull( createdCustomer.getAllowDelegatedAccess() );
        assertNotNull( createdCustomer.getAttributes() );
        //assertNotNull( createdCustomer.getAttributes().getEtag() );
        assertNotNull( createdCustomer.getAttributes().getObjectType() );

        assertNotNull( createdCustomer.getBillingProfile() );
        assertEquals( expectedCulture, createdCustomer.getBillingProfile().getCulture() );
        assertEquals( expectedEmail, createdCustomer.getBillingProfile().getEmail() );
        assertEquals( expectedLanguage, createdCustomer.getBillingProfile().getLanguage() );
        assertEquals( expectedCompanyName, createdCustomer.getBillingProfile().getCompanyName() );

        //assertNotNull( createdCustomer.getCommerceId() );

        assertNotNull( createdCustomer.getCompanyProfile() );
        assertEquals( expectedDomain, createdCustomer.getCompanyProfile().getDomain() );

        assertNotNull( createdCustomer.getId() );
        //assertNotNull( createdCustomer.getLinks() );
        //assertNotNull( createdCustomer.getLinks().getSelf() );
        assertNotNull( createdCustomer.getRelationshipToPartner() );
    }
}
