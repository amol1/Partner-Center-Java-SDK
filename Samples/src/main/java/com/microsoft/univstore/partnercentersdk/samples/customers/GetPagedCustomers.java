package com.microsoft.univstore.partnercentersdk.samples.customers;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetPagedCustomers.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets a partner customers in pages.
 */
public class GetPagedCustomers
    extends BasePartnerScenario
{
    /**
     * The customer page size.
     */
    private final int customerPageSize;

    /**
     * Initializes a new instance of the {@link #GetPagedCustomers} class.
     * 
     * @param context The scenario context.
     * @param customerPageSize The number of customers to return per page.
     */
    public GetPagedCustomers( IScenarioContext context )
    {
        this( context, 0 );
    }

    public GetPagedCustomers( IScenarioContext context, int customerPageSize )
    {
        super( "Get Paged customers", context );
        this.customerPageSize = customerPageSize;
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Querying customers" );
        // query the customers, get the first page if a page size was set, otherwise get all customers
        SeekBasedResourceCollection<Customer> customersPage = ( this.customerPageSize <= 0 )
                        ? partnerOperations.getCustomers().get()
                        : partnerOperations.getCustomers().query( QueryFactory.buildIndexedQuery( this.customerPageSize ) );
        this.getContext().getConsoleHelper().stopProgress();
        // create a customer enumerator which will aid us in traversing the customer pages
        IResourceCollectionEnumerator<SeekBasedResourceCollection<Customer>> customersEnumerator =
            partnerOperations.getEnumerators().getCustomers().create( customersPage );
        int pageNumber = 1;
        while ( customersEnumerator.hasValue() )
        {
            // print the current customer results page
            this.getContext().getConsoleHelper().writeObject( customersEnumerator.getCurrent(),
                                                              MessageFormat.format( "Customer Page: {0}",
                                                                                    pageNumber++ ) );
            System.out.println();
            System.out.println( "Press Enter to retrieve the next customers page" );
            ConsoleHelper.getInstance().getScanner().nextLine();
            this.getContext().getConsoleHelper().startProgress( "Getting next customers page" );
            // get the next page of customers
            customersEnumerator.next();
            this.getContext().getConsoleHelper().stopProgress();
        }
    }

}
