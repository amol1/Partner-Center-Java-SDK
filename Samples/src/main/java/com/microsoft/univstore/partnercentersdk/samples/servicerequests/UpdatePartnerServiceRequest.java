package com.microsoft.univstore.partnercentersdk.samples.servicerequests;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequestNote;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="UpdatePartnerServiceRequest.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Updates a partner's service request.
 */
public class UpdatePartnerServiceRequest
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #UpdatePartnerServiceRequest} class.
     * 
     * @param context The scenario context.
     */
    public UpdatePartnerServiceRequest( IScenarioContext context )
    {
        super( "Update a partner's service request", context );
    }

    /**
     * executes the update partner service request details scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String serviceRequestIdToUpdate =
            this.getContext().getConfiguration().getScenarioSettings().get( "DefaultServiceRequestId" );
        if ( StringHelper.isNullOrWhiteSpace( serviceRequestIdToUpdate ) )
        {
            // prompt the user the enter the service request ID
            serviceRequestIdToUpdate =
                this.getContext().getConsoleHelper().readNonEmptyString( "Please enter the ID of the service request to update",
                                                                         "The service request ID can't be empty" );
        }
        else
        {
            ConsoleHelper.getInstance().warning( MessageFormat.format( "Found service request ID: {0} in configuration.",
                                                                       serviceRequestIdToUpdate ) );
        }
        this.getContext().getConsoleHelper().startProgress( "Retrieving service request to be updated" );
        // Retrieve service request
        ServiceRequest serviceRequest = partnerOperations.getServiceRequests().byId( serviceRequestIdToUpdate ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( serviceRequest, "Service Request to be updated" );
        this.getContext().getConsoleHelper().startProgress( "Updating Service Request" );
        // Updating service request
        ServiceRequestNote note = new ServiceRequestNote();
        note.setText( "Sample note" );
        ServiceRequest newServiceRequest = new ServiceRequest();
        newServiceRequest.setNewNote( note );
        ServiceRequest updatedServiceRequest =
            partnerOperations.getServiceRequests().byId( serviceRequestIdToUpdate ).update( newServiceRequest );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( updatedServiceRequest, "Updated Service Request details" );
    }

}
