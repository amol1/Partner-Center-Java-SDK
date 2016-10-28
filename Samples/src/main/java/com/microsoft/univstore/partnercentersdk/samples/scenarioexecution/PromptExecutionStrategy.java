package com.microsoft.univstore.partnercentersdk.samples.scenarioexecution;

import com.microsoft.univstore.partnercentersdk.samples.IPartnerScenario;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="PromptExecutionStrategy.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * An scenario execution strategy that prompts the user repeat or exit the current scenario.
 */
public class PromptExecutionStrategy
    implements IScenarioExecutionStrategy
{
    /**
     * Determines whether the scenario is complete or it should be repeated.
     * 
     * @param scenario The scenario under consideration.
     * @return True is the scenario is complete, False is it should be repeated.
     */
    public Boolean isScenarioComplete( IPartnerScenario scenario )
    {
        ConsoleHelper.getInstance().warning( "Press Q to return to the previous screen or R to repeat the current scenario:",
                                             false );
        String keyRead = ConsoleHelper.getInstance().getScanner().nextLine();
        while ( !keyRead.equalsIgnoreCase( "r" ) && !keyRead.equalsIgnoreCase( "q" ) )
        {
            keyRead = ConsoleHelper.getInstance().getScanner().nextLine();
        }
        return keyRead.equalsIgnoreCase( "q" );
    }

}
