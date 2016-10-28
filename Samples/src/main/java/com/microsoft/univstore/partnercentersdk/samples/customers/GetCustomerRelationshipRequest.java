package com.microsoft.univstore.partnercentersdk.samples.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.relationshiprequests.CustomerRelationshipRequest;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetCustomerRelationshipRequest.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets the request which establishes a relationship between the partner and their customers.
 */
public class GetCustomerRelationshipRequest
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetCustomerRelationshipRequest} class.
     * 
     * @param context The scenario context.
     */
    public GetCustomerRelationshipRequest( IScenarioContext context )
    {
        super( "Get customer relationship request", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Retrieving customer relationship request" );
        CustomerRelationshipRequest customerRelationshipRequest =
            partnerOperations.getCustomers().getRelationshipRequests().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customerRelationshipRequest,
                                                          "Customer relationship request" );
    }

}
