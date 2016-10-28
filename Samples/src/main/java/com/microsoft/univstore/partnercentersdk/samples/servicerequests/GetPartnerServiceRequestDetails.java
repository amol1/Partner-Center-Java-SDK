package com.microsoft.univstore.partnercentersdk.samples.servicerequests;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="GetPartnerServiceRequestDetails.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets a service request details for a partner.
 */
public class GetPartnerServiceRequestDetails
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetPartnerServiceRequestDetails} class.
     * 
     * @param context The scenario context.
     */
    public GetPartnerServiceRequestDetails( IScenarioContext context )
    {
        super( "Get service request details", context );
    }

    /**
     * executes the get service request details scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String serviceRequestIdToRetrieve =
            this.getContext().getConfiguration().getScenarioSettings().get( "DefaultServiceRequestId" );
        if ( StringHelper.isNullOrWhiteSpace( serviceRequestIdToRetrieve ) )
        {
            // prompt the user the enter the service request ID
            serviceRequestIdToRetrieve =
                this.getContext().getConsoleHelper().readNonEmptyString( "Please enter the ID of the service request to retrieve ",
                                                                         "The ID can't be empty" );
        }
        else
        {
            ConsoleHelper.getInstance().warning( MessageFormat.format( "Found service request ID: {0} in configuration.",
                                                                       serviceRequestIdToRetrieve ) );
        }
        this.getContext().getConsoleHelper().startProgress( "Retrieving Service Request" );
        ServiceRequest serviceRequest = partnerOperations.getServiceRequests().byId( serviceRequestIdToRetrieve ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( serviceRequest, "Service Request details" );
    }

}
