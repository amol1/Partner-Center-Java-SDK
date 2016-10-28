package com.microsoft.univstore.partnercentersdk.samples.offers;

import java.text.MessageFormat;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.offers.OfferCategory;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="GetOfferCategories.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that gets all offer categories.
 */
public class GetOfferCategories
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #GetOfferCategories} class.
     * 
     * @param context The scenario context.
     */
    public GetOfferCategories( IScenarioContext context )
    {
        super( "Get offer categories", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String countryCode =
            this.getContext().getConsoleHelper().readNonEmptyString( "Enter the 2 digit country code to get its supported offer categories",
                                                                     "The country code can't be empty" );
        this.getContext().getConsoleHelper().startProgress( MessageFormat.format( "Getting offer categories for {0}",
                                                                                  countryCode ) );
        ResourceCollection<OfferCategory> offerCategories = partnerOperations.getOfferCategories().get( countryCode );
        this.getContext().getConsoleHelper().stopProgress();
        this.getContext().getConsoleHelper().writeObject( offerCategories,
                                                          MessageFormat.format( "Offer categories in {0}",
                                                                                countryCode ) );
    }

}
