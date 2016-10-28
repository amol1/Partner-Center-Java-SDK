package com.microsoft.univstore.partnercentersdk.samples.servicerequests;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumerator;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.query.QueryFactory;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetPagedPartnerServiceRequests.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Get paged partner service requests.
 */
public class GetPagedPartnerServiceRequests
    extends BasePartnerScenario
{
    /**
     * The service requests page size.
     */
    private final int serviceRequestPageSize;

    /**
     * Initializes a new instance of the {@link #GetPagedPartnerServiceRequests} class.
     * 
     * @param context The scenario context.
     * @param serviceRequestPageSize The number of service requests to return per page.
     */
    public GetPagedPartnerServiceRequests( IScenarioContext context, int serviceRequestPageSize )
    {
        super( "Get paged partner service requests", context );
        this.serviceRequestPageSize = serviceRequestPageSize;
    }

    /**
     * executes the get paged partner service requests scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Querying Service Requests" );
        // query the service requests, get the first page if a page size was set
        SeekBasedResourceCollection<ServiceRequest> serviceRequestsPage =
            partnerOperations.getServiceRequests().query( QueryFactory.buildIndexedQuery( this.serviceRequestPageSize ) );
        this.getContext().getConsoleHelper().stopProgress();
        // create a service requests enumerator which will aid us in traversing the service requests pages
        IResourceCollectionEnumerator<SeekBasedResourceCollection<ServiceRequest>> serviceRequestsEnumerator =
            partnerOperations.getEnumerators().getServiceRequests().create( serviceRequestsPage );
        int pageNumber = 1;
        while ( serviceRequestsEnumerator.hasValue() )
        {
            this.getContext().getConsoleHelper().writeObject( serviceRequestsEnumerator.getCurrent(),
                                                              MessageFormat.format( "Service Requests Page: {0}",
                                                                                    pageNumber++ ) );

            ConsoleHelper.getInstance().warning( "Press Enter to retrieve the next service request page" );
            ConsoleHelper.getInstance().getScanner().nextLine();
            this.getContext().getConsoleHelper().startProgress( "Getting next service request page" );
            // get the next page of service requests
            serviceRequestsEnumerator.next();
            this.getContext().getConsoleHelper().stopProgress();
        }
    }

}
