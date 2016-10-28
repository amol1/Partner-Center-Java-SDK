package com.microsoft.univstore.partnercentersdk.samples;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.univstore.partnercentersdk.models.customers.CustomerSearchField;
import com.microsoft.univstore.partnercentersdk.samples.context.ScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.customers.CheckDomainAvailability;
import com.microsoft.univstore.partnercentersdk.samples.customers.CreateCustomer;
import com.microsoft.univstore.partnercentersdk.samples.customers.DeleteCustomerFromTipAccount;
import com.microsoft.univstore.partnercentersdk.samples.customers.FilterCustomers;
import com.microsoft.univstore.partnercentersdk.samples.customers.GetCustomerDetails;
import com.microsoft.univstore.partnercentersdk.samples.customers.GetCustomerManagedServices;
import com.microsoft.univstore.partnercentersdk.samples.customers.GetCustomerRelationshipRequest;
import com.microsoft.univstore.partnercentersdk.samples.customers.GetPagedCustomers;
import com.microsoft.univstore.partnercentersdk.samples.customers.UpdateCustomerBillingProfile;
import com.microsoft.univstore.partnercentersdk.samples.indirectpartners.GetSubscriptionsByMpnId;
import com.microsoft.univstore.partnercentersdk.samples.indirectpartners.VerifyPartnerMpnId;
import com.microsoft.univstore.partnercentersdk.samples.invoice.GetInvoiceSummary;
import com.microsoft.univstore.partnercentersdk.samples.invoice.GetInvoice;
import com.microsoft.univstore.partnercentersdk.samples.invoice.GetInvoiceLineItems;
import com.microsoft.univstore.partnercentersdk.samples.invoice.GetPagedInvoices;
import com.microsoft.univstore.partnercentersdk.samples.offers.GetOfferCategories;
import com.microsoft.univstore.partnercentersdk.samples.offers.GetOffers;
import com.microsoft.univstore.partnercentersdk.samples.orders.CreateOrder;
import com.microsoft.univstore.partnercentersdk.samples.orders.GetOrders;
import com.microsoft.univstore.partnercentersdk.samples.ratedusage.GetCustomerSubscriptionsUsage;
import com.microsoft.univstore.partnercentersdk.samples.ratedusage.GetCustomerUsageSummary;
import com.microsoft.univstore.partnercentersdk.samples.ratedusage.GetSubscriptionResourceUsage;
import com.microsoft.univstore.partnercentersdk.samples.servicerequests.CreatePartnerServiceRequest;
import com.microsoft.univstore.partnercentersdk.samples.servicerequests.GetCustomerServiceRequests;
import com.microsoft.univstore.partnercentersdk.samples.servicerequests.GetPagedPartnerServiceRequests;
import com.microsoft.univstore.partnercentersdk.samples.servicerequests.GetPartnerServiceRequestDetails;
import com.microsoft.univstore.partnercentersdk.samples.servicerequests.GetServiceRequestSupportTopics;
import com.microsoft.univstore.partnercentersdk.samples.servicerequests.UpdatePartnerServiceRequest;
import com.microsoft.univstore.partnercentersdk.samples.subscriptions.AddSubscriptionAddOn;
import com.microsoft.univstore.partnercentersdk.samples.subscriptions.UpdateSubscription;
import com.microsoft.univstore.partnercentersdk.samples.subscriptions.UpgradeSubscription;

// -----------------------------------------------------------------------
// <copyright file="Program.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The main program class for the partner center .NET SDK samples.
 */
public class Program
{
    /**
     * The main entry function.
     * 
     * @param args Program arguments.
     */
    public static void main( String[] args )
    {
        ScenarioContext context = new ScenarioContext();
        List<IPartnerScenario> mainScenarios = new ArrayList<IPartnerScenario>();
        mainScenarios.add( Program.getCustomerScenarios( context ) );
        mainScenarios.add( Program.getIndirectPartnerScenarios( context ) );
        mainScenarios.add( Program.getOfferScenarios( context ) );
        mainScenarios.add( Program.getOrderScenarios( context ) );
        mainScenarios.add( Program.getSubscriptionScenarios( context ) );
        mainScenarios.add( Program.getRatedUsageScenarios( context ) );
        mainScenarios.add( Program.getServiceRequestScenarios( context ) );
        mainScenarios.add( Program.getInvoiceScenarios( context ) );
        // run the main scenario
        new AggregatePartnerScenario( "Partner SDK samples", mainScenarios, context ).run();
    }

    /**
     * Gets the customer scenarios.
     * 
     * @param context A scenario context.
     * @return The customer scenarios.
     */
    private static IPartnerScenario getCustomerScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> customerFilteringScenarios = new ArrayList<IPartnerScenario>();
        customerFilteringScenarios.add( new FilterCustomers( "Filter by company name", CustomerSearchField.COMPANY_NAME,
                                                             context ) );
        customerFilteringScenarios.add( new FilterCustomers( "Filter by domain name", CustomerSearchField.DOMAIN_NAME,
                                                             context ) );
        List<IPartnerScenario> customerScenarios = new ArrayList<IPartnerScenario>();

        customerScenarios.add( new CreateCustomer( context ) );
        customerScenarios.add( new CheckDomainAvailability( context ) );
        customerScenarios.add( new GetPagedCustomers( context,
                                                      Integer.parseInt( context.getConfiguration().getScenarioSettings().get( "CustomerPageSize" ) ) ) );
        customerScenarios.add( new AggregatePartnerScenario( "Customer filtering", customerFilteringScenarios,
                                                             context ) );
        customerScenarios.add( new GetCustomerDetails( context ) );
        customerScenarios.add( new DeleteCustomerFromTipAccount( context ) );
        customerScenarios.add( new GetCustomerManagedServices( context ) );
        customerScenarios.add( new GetCustomerRelationshipRequest( context ) );
        customerScenarios.add( new UpdateCustomerBillingProfile( context ) );
        return new AggregatePartnerScenario( "Customer samples", customerScenarios, context );
    }

    /**
     * Gets the indirect partner scenarios.
     *
     * @param context A scenario context.
     * @return The indirect partner scenarios.
     */
    private static IPartnerScenario getIndirectPartnerScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> indirectPartnerScenarios = new ArrayList<IPartnerScenario>();
        indirectPartnerScenarios.add( new VerifyPartnerMpnId( context ) );
        indirectPartnerScenarios.add( new GetSubscriptionsByMpnId( context ) );

        return new AggregatePartnerScenario( "Indirect partner samples", indirectPartnerScenarios, context );
    }

    /**
     * Gets the offer scenarios.
     *
     * @param context A scenario context.
     * @return The offer scenarios.
     */
    private static IPartnerScenario getOfferScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> offerScenarios = new ArrayList<IPartnerScenario>();
        offerScenarios.add( new GetOfferCategories( context ) );
        offerScenarios.add( new GetOffers( context ) );
        return new AggregatePartnerScenario( "Offer samples", offerScenarios, context );
    }

    /**
     * Gets the order scenarios.
     *
     * @param context A scenario context.
     * @return The order scenarios.
     */
    private static IPartnerScenario getOrderScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> orderScenarios = new ArrayList<IPartnerScenario>();
        orderScenarios.add( new CreateOrder( context ) );
        orderScenarios.add( new GetOrders( context ) );
        return new AggregatePartnerScenario( "Order samples", orderScenarios, context );
    }

    /**
     * Gets the subscription scenarios.
     *
     * @param context A scenario context.
     * @return The subscription scenarios.
     */
    private static IPartnerScenario getSubscriptionScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> subscriptionScenarios = new ArrayList<IPartnerScenario>();
        subscriptionScenarios.add( new UpdateSubscription( context ) );
        subscriptionScenarios.add( new UpgradeSubscription( context ) );
        subscriptionScenarios.add( new AddSubscriptionAddOn( context ) );
        return new AggregatePartnerScenario( "Subscription samples", subscriptionScenarios, context );
    }

    /**
     * Gets the rated usage scenarios.
     *
     * @param context A scenario context.
     * @return The rated usage scenarios.
     */
    private static IPartnerScenario getRatedUsageScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> ratedUsageScenarios = new ArrayList<IPartnerScenario>();
        ratedUsageScenarios.add( new GetCustomerUsageSummary( context ) );
        ratedUsageScenarios.add( new GetCustomerSubscriptionsUsage( context ) );
        ratedUsageScenarios.add( new GetSubscriptionResourceUsage( context ) );
        return new AggregatePartnerScenario( "Rated usage samples", ratedUsageScenarios, context );
    }

    /**
     * Gets the service request scenarios.
     *
     * @param context A scenario context.
     * @return The service request scenarios.
     */
    private static IPartnerScenario getServiceRequestScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> serviceRequestScenarios = new ArrayList<IPartnerScenario>();
        serviceRequestScenarios.add( new CreatePartnerServiceRequest( context ) );
        serviceRequestScenarios.add( new GetCustomerServiceRequests( context ) );
        serviceRequestScenarios.add( new GetPagedPartnerServiceRequests( context,
                                                                         Integer.parseInt( context.getConfiguration().getScenarioSettings().get( "ServiceRequestPageSize" ) ) ) );
        serviceRequestScenarios.add( new GetPartnerServiceRequestDetails( context ) );
        serviceRequestScenarios.add( new GetServiceRequestSupportTopics( context ) );
        serviceRequestScenarios.add( new UpdatePartnerServiceRequest( context ) );
        return new AggregatePartnerScenario( "Service request samples", serviceRequestScenarios, context );
    }

    /**
     * Gets the invoice scenarios.
     *
     * @param context A scenario context.
     * @return The invoice scenarios.
     */
    private static IPartnerScenario getInvoiceScenarios( IScenarioContext context )
    {
        List<IPartnerScenario> invoiceScenarios = new ArrayList<IPartnerScenario>();
        invoiceScenarios.add( new GetInvoiceSummary( context ) );
        invoiceScenarios.add( new GetInvoice( context ) );
        invoiceScenarios.add( new GetInvoiceLineItems( context,
                                                       Integer.parseInt( context.getConfiguration().getScenarioSettings().get( "InvoicePageSize" ) ) ) );
        invoiceScenarios.add( new GetPagedInvoices( context,
                                                    Integer.parseInt( context.getConfiguration().getScenarioSettings().get( "InvoicePageSize" ) ) ) );
        return new AggregatePartnerScenario( "Invoice samples", invoiceScenarios, context );
    }

}
