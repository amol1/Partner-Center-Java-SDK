package com.microsoft.univstore.partnercentersdk.samples.indirectpartners;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetSubscriptionsByMpnId.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that gets a customer's subscriptions which belong to a partner MPN ID.
 */
public class GetSubscriptionsByMpnId
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetSubscriptionsByMpnId} class.
     * 
     * @param context The scenario context.
     */
    public GetSubscriptionsByMpnId( IScenarioContext context )
    {
        super( "Get customer subscriptions by partner MPN ID", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        String customerId = this.obtainCustomerId();
        String partnerMpnId = this.obtainMpnId();
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting subscriptions" );
        ResourceCollection<Subscription> customerSubscriptionsByMpnId =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().byPartner( partnerMpnId ).get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( customerSubscriptionsByMpnId,
                                                          MessageFormat.format( "Customer subscriptions by MPN ID: {0}",
                                                                                partnerMpnId ) );
    }

}
