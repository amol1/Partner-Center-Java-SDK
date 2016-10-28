package com.microsoft.univstore.partnercentersdk.samples.customers;

import java.util.Random;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.Address;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerBillingProfile;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerCompanyProfile;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="CreateCustomer.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Creates a new customer for a partner.
 */
public class CreateCustomer
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #CreateCustomer} class.
     * 
     * @param context The scenario context.
     */
    public CreateCustomer( IScenarioContext context )
    {
        super( "Create a new customer", context );
    }

    /**
     * executes the create customer scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();

        Address address = new Address();
        address.setFirstName( "Engineer" );
        address.setLastName( "In Test" );
        address.setAddressLine1( "4001 156th Ave" );
        address.setCity( "Redmond" );
        address.setCity( "Redmond" );
        address.setState( "WA" );
        address.setCountry( "US" );
        address.setPostalCode( "98052" );
        address.setPhoneNumber( "4257778899" );

        CustomerBillingProfile billingProfile = new CustomerBillingProfile();
        billingProfile.setCulture( "EN-US" );
        billingProfile.setEmail( "SomeEmail@MS.com" );
        billingProfile.setLanguage( "En" );
        billingProfile.setCompanyName( "Some Company" + new Random().nextInt() );
        billingProfile.setDefaultAddress( address );

        CustomerCompanyProfile companyProfile = new CustomerCompanyProfile();
        companyProfile.setDomain( "SampleApplication" + Math.abs( new Random().nextInt() ) + ".onmicrosoft.com" );

        Customer customerToCreate = new Customer();
        customerToCreate.setBillingProfile( billingProfile );
        customerToCreate.setCompanyProfile( companyProfile );

        this.getContext().getConsoleHelper().writeObject( customerToCreate, "New user Information" );
        this.getContext().getConsoleHelper().startProgress( "Creating user" );
        Customer newCustomer = partnerOperations.getCustomers().create( customerToCreate );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().success( "Success!" );
        this.getContext().getConsoleHelper().writeObject( newCustomer, "Created user Information" );
    }

}
