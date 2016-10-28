package com.microsoft.univstore.partnercentersdk.samples.servicerequests;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.SupportTopic;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetServiceRequestSupportTopics.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Gets the list of support topics.
 */
public class GetServiceRequestSupportTopics
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetServiceRequestSupportTopics} class.
     * 
     * @param context The scenario context.
     */
    public GetServiceRequestSupportTopics( IScenarioContext context )
    {
        super( "Get a list of service request support topics", context );
    }

    /**
     * executes the get service request support topics scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting support topics" );
        // Get support Topics
        ResourceCollection<SupportTopic> supportTopicsCollection =
            partnerOperations.getServiceRequests().getSupportTopics().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( supportTopicsCollection, "Support topics collection" );
    }

}
