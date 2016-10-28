package com.microsoft.univstore.partnercentersdk.samples.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.CustomerSearchField;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.query.filters.FieldFilterOperation;
import com.microsoft.univstore.partnercentersdk.models.query.filters.SimpleFieldFilter;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="FilterCustomers.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Returns customers according to a provided filter.
 */
public class FilterCustomers
    extends BasePartnerScenario
{
    /**
     * The search field.
     */
    private final CustomerSearchField customerSearchField;

    /**
     * Initializes a new instance of the {@link #FilterCustomers} class.
     * 
     * @param title The scenario title.
     * @param customerSearchField The search filed.
     * @param context The scenario context.
     */
    public FilterCustomers( String title, CustomerSearchField customerSearchField, IScenarioContext context )
    {
        super( title, context );
        this.customerSearchField = customerSearchField;
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String searchPrefix = this.getContext().getConsoleHelper().readNonEmptyString( "Enter the prefix to search for",
                                                                                       "The entered prefix is empty" );
        this.getContext().getConsoleHelper().startProgress( "Filtering" );
        ResourceCollection<Customer> customers =
            partnerOperations.getCustomers().query( QueryFactory.buildSimpleQuery( new SimpleFieldFilter( this.customerSearchField.toString(),
                                                                                                          searchPrefix,
                                                                                                          FieldFilterOperation.STARTS_WITH ) ) );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customers, "Customer matches" );
    }

}
