package com.microsoft.univstore.partnercentersdk.samples;

import java.util.List;

// -----------------------------------------------------------------------
// <copyright file="IPartnerScenario.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents a partner scenario that demos one or more related partner center APIs.
 */
public interface IPartnerScenario
{
    /**
     * Gets the scenario title.
     */
    String getTitle();

    /**
     * Gets the children scenarios of the current scenario.
     */
    List<IPartnerScenario> getChildren();

    /**
     * Gets the scenario context.
     */
    IScenarioContext getContext();

    /**
     * Runs the scenario.
     */
    void run();

}
