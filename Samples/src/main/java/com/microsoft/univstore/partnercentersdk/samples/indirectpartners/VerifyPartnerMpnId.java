package com.microsoft.univstore.partnercentersdk.samples.indirectpartners;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.partners.PartnerNetworkProfile;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="VerifyPartnerMpnId.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that verifies a partner MPN ID.
 */
public class VerifyPartnerMpnId
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #VerifyPartnerMpnId} class.
     * 
     * @param context The scenario context.
     */
    public VerifyPartnerMpnId( IScenarioContext context )
    {
        super( "Verify partner MPN ID", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        this.getContext().getConsoleHelper().startProgress( "Getting the logged in partner's profile" );
        PartnerNetworkProfile currentPartnerProfile = partnerOperations.getProfiles().getPartnerNetworkProfile().get();
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( currentPartnerProfile, "Logged in partner profile" );
        String partnerMpnId = this.obtainMpnId( "Enter the MPN ID to verify" );
        this.getContext().getConsoleHelper().startProgress( MessageFormat.format( "Getting the partner profile for MPN ID: {0}",
                                                                                  partnerMpnId ) );
        PartnerNetworkProfile partnerProfile =
            partnerOperations.getProfiles().getPartnerNetworkProfile().get( partnerMpnId );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( partnerProfile, "Partner profile" );
    }

}
