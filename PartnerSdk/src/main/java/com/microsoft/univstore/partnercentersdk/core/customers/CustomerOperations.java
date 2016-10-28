package com.microsoft.univstore.partnercentersdk.core.customers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.customers.profiles.CustomerProfileCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.customers.profiles.ICustomerProfileCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.managedservices.IManagedServiceCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.managedservices.ManagedServiceCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.orders.IOrderCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.orders.OrderCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.servicerequests.CustomerServiceRequestCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.servicerequests.IServiceRequestCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.subscriptions.ISubscriptionCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.subscriptions.SubscriptionCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;

// -----------------------------------------------------------------------
// <copyright file="CustomerOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements a single customer operations.
 */
public class CustomerOperations
    extends BasePartnerComponentString
    implements ICustomerOperations
{
    /**
     * The customer subscriptions operations.
     */
    private ISubscriptionCollectionOperations subscriptions;

    /**
     * The customer orders operations.
     */
    private IOrderCollectionOperations orders;

    /**
     * The customer profiles operations.
     */
    private ICustomerProfileCollectionOperations profiles;

    /**
     * The customer service requests operations.
     */
    private IServiceRequestCollectionOperations serviceRequests;

    /**
     * The customer managed services.
     */
    private IManagedServiceCollectionOperations managedServices;

    /**
     * The customer summary for usage-based subscriptions operations.
     */
    private ICustomerUsageSummaryOperations usageSummary;

    /**
     * The operations for the spending budget allocated to the customer by the partner.
     */
    private ICustomerUsageSpendingBudgetOperations usageBudget;

    private String customerId;

    /**
     * Initializes a new instance of the {@link #CustomerOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     */
    public CustomerOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set" );
        }
        this.customerId = customerId;
    }

    /**
     * Gets the orders behavior for the customer.
     *
     * @return The customer orders.
     */
    @Override
    public IOrderCollectionOperations getOrders()
    {
        if ( this.orders == null )
        {
            this.orders = new OrderCollectionOperations( this.getPartner(), this.getContext() );
        }
        return this.orders;
    }

    /**
     * Obtains the profiles behavior for the customer.
     * 
     * @return The customer profiles.
     */
    @Override
    public ICustomerProfileCollectionOperations getProfiles()
    {
        if ( this.profiles == null )
        {
            this.profiles = new CustomerProfileCollectionOperations( this.getPartner(), this.getContext() );
        }
        return this.profiles;
    }

    @Override
    public ISubscriptionCollectionOperations getSubscriptions()
    {
        if ( subscriptions == null )
        {
            subscriptions = new SubscriptionCollectionOperations( this.getPartner(), this.getContext() );
        }
        return subscriptions;
    }

    /**
     * Obtains the service requests behavior for the customer.
     *
     * @return The customer service request operations.
     */
    @Override
    public IServiceRequestCollectionOperations getServiceRequests()
    {
        if ( this.serviceRequests == null )
        {
            this.serviceRequests = new CustomerServiceRequestCollectionOperations( this.getPartner(), this.customerId );
        }
        return this.serviceRequests;
    }

    /**
     * Obtains the managed services behavior for the customer.
     *
     * @return The customer managed services operations.
     */
    @Override
    public IManagedServiceCollectionOperations getManagedServices()
    {
        if ( this.managedServices == null )
        {
            this.managedServices = new ManagedServiceCollectionOperations( this.getPartner(), this.customerId );
        }
        return this.managedServices;
    }

    /**
     * Obtains the customer usage summary behavior for the customer.
     *
     * @return The customer usage summary operations.
     */
    @Override
    public ICustomerUsageSummaryOperations getUsageSummary()
    {
        if ( this.usageSummary == null )
        {
            this.usageSummary = new CustomerUsageSummaryOperations( this.getPartner(), customerId );
        }
        return this.usageSummary;
    }

    /**
     * Obtains the usage spending budget behavior for the customer.
     *
     * @return The customer usage spending budget operations.
     */
    @Override
    public ICustomerUsageSpendingBudgetOperations getUsageBudget()
    {
        if ( this.usageBudget == null )
        {
            this.usageBudget = new CustomerUsageSpendingBudgetOperations( this.getPartner(), customerId );
        }
        return this.usageBudget;
    }

    /**
     * Retrieves information of a specific customer.
     * 
     * @return The customer object.
     */
    @Override
    public Customer get()
    {
        IPartnerServiceProxy<Customer, Customer> partnerServiceProxy =
            new PartnerServiceProxy<Customer, Customer>( new TypeReference<Customer>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomer" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }

    /**
     * Deletes the customer from a testing in production account. This won't work for real accounts.
     */
    @Override
    public void delete()
    {
        IPartnerServiceProxy<Customer, Customer> partnerServiceProxy =
            new PartnerServiceProxy<Customer, Customer>( new TypeReference<Customer>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "DeleteCustomer" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        partnerServiceProxy.delete();
    }

}