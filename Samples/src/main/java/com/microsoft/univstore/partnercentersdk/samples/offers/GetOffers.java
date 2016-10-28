package com.microsoft.univstore.partnercentersdk.samples.offers;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetOffers.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that retrieves all the offers supported in a country.
 */
public class GetOffers
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetOffers} class.
     * 
     * @param context The scenario context.
     */
    public GetOffers( IScenarioContext context )
    {
        super( "Get offers", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String countryCode =
            this.getContext().getConsoleHelper().readNonEmptyString( "Enter the 2 digit country code to get its supported offers",
                                                                     "The country code can't be empty" );
        this.getContext().getConsoleHelper().startProgress( MessageFormat.format( "Getting offers for {0}",
                                                                                  countryCode ) );
        ResourceCollection<Offer> offers = partnerOperations.getOffers().get( countryCode);
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( offers,
                                                          MessageFormat.format( "Offers in {0}", countryCode ) );
    }

}
