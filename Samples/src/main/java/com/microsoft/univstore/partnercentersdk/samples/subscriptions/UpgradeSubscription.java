package com.microsoft.univstore.partnercentersdk.samples.subscriptions;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.subscriptions.ISubscriptionOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Upgrade;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.UpgradeResult;
import com.microsoft.univstore.partnercentersdk.samples.BasePartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.IScenarioContext;

// -----------------------------------------------------------------------
// <copyright file="UpgradeSubscription.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A scenario that upgrades a customer subscription to a higher skew.
 */
public class UpgradeSubscription
    extends BasePartnerScenario
{
    /**
     * Initializes a new instance of the {@link #UpgradeSubscription} class.
     * 
     * @param context The scenario context.
     */
    public UpgradeSubscription( IScenarioContext context )
    {
        super( "Upgrade customer subscription", context );
    }

    /**
     * Executes the scenario.
     */
    @Override
    protected void runScenario()
    {
        IPartnerOperations partnerOperations = this.getContext().getUserPartnerOperations();
        String customerId = this.obtainCustomerId();
        String subscriptionId =
            this.obtainSubscriptionId( customerId, "Enter the ID of the subscription to find upgrades for" );
        ISubscriptionOperations subscriptionOperations =
            partnerOperations.getCustomers().byId( customerId ).getSubscriptions().byId( subscriptionId );
        this.getContext().getConsoleHelper().startProgress( "Retrieving subscription upgrades" );
        ResourceCollection<Upgrade> upgrades = subscriptionOperations.getUpgrades().get();
        this.getContext().getConsoleHelper().stopProgress();
        if ( upgrades.getTotalCount() <= 0 )
        {
            this.getContext().getConsoleHelper().error( "This subscription has no upgrades" );
        }
        else
        {
            this.getContext().getConsoleHelper().writeObject( upgrades, "Available upgrades" );
            // prompt the user to enter the offer ID of the upgrade he wishes to get
            String upgradeOfferId =
                this.getContext().getConsoleHelper().readNonEmptyString( "Enter the upgrade offer ID",
                                                                         "Upgrade offer ID can't be empty" );

            Upgrade selectedUpgrade = null;
            for ( Upgrade upgrade : upgrades.getItems() )
            {
                if ( upgrade.getTargetOffer().getId() == upgradeOfferId )
                {
                    selectedUpgrade = upgrade;
                    break;
                }
            }

            if ( selectedUpgrade == null )
            {
                this.getContext().getConsoleHelper().error( "The entered upgrade offer ID was not found in the list of upgrades" );
            }
            else if ( !selectedUpgrade.isEligible() )
            {
                this.getContext().getConsoleHelper().error( "The entered upgrade is not eligible for the following reasons:" );
                this.getContext().getConsoleHelper().writeObject( selectedUpgrade.getUpgradeErrors(),
                                                                  "Upgrade errors list" );
            }
            else
            {
                // the selected upgrade is eligible, go ahead and perform the upgrade
                this.getContext().getConsoleHelper().startProgress( "Upgrading subscription" );
                UpgradeResult updgradeResult = subscriptionOperations.getUpgrades().create( selectedUpgrade );
                this.getContext().getConsoleHelper().stopProgress();
                this.getContext().getConsoleHelper().writeObject( updgradeResult, "Upgrade details" );
            }
        }
    }

}
