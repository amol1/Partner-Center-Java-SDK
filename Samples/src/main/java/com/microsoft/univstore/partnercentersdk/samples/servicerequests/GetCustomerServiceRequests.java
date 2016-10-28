package com.microsoft.univstore.partnercentersdk.samples.servicerequests;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetCustomerServiceRequests.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets customer service requests.
 */
public class GetCustomerServiceRequests
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetCustomerServiceRequests} class.
     * 
     * @param context The scenario context.
     */
    public GetCustomerServiceRequests( IScenarioContext context )
    {
        super( "Get customer service requests", context );
    }

    /**
     * executes the get customer service requests scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerIdToRetrieve =
            this.getContext().getConfiguration().getScenarioSettings().get( "DefaultCustomerId" );
        if ( StringHelper.isNullOrWhiteSpace( customerIdToRetrieve ) )
        {
            // prompt the user the enter the customer ID
            customerIdToRetrieve =
                this.getContext().getConsoleHelper().readNonEmptyString( "Please enter the ID of the customer to retrieve: ",
                                                                         "The customer ID can't be empty" );
        }
        else
        {
            ConsoleHelper.getInstance().warning( MessageFormat.format( "Found customer ID: {0} in configuration.",
                                                                       customerIdToRetrieve ) );
        }
        this.getContext().getConsoleHelper().startProgress( "Retrieving Customer's Service Requests" );
        ResourceCollection<ServiceRequest> serviceRequests =
            partnerOperations.getCustomers().byId( customerIdToRetrieve ).getServiceRequests().get();
        this.getContext().getConsoleHelper().stopProgress();
        if ( !serviceRequests.getItems().iterator().hasNext() )
        {
            ConsoleHelper.getInstance().warning( "No Service requests found for the given customer." );
        }
        else
        {
            this.getContext().getConsoleHelper().writeObject( serviceRequests, "Service Request results." );
        }
    }

}
