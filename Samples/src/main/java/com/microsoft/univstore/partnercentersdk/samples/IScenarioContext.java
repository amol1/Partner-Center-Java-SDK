package com.microsoft.univstore.partnercentersdk.samples;

import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.samples.configuration.Configuration;
import com.microsoft.univstore.partnercentersdk.samples.helpers.ConsoleHelper;

// -----------------------------------------------------------------------
// <copyright file="IScenarioContext.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Holds context properties useful to the scenarios.
 */
public interface IScenarioContext
{
    /**
     * Gets a partner operations instance which is user based authenticated.
     */
    IAggregatePartnerOperations getUserPartnerOperations();

    /**
     * Gets a partner operations instance which is application based authenticated.
     */
    IAggregatePartnerOperations getAppPartnerOperations();

    /**
     * Gets a configuration instance.
     */
    Configuration getConfiguration();

    /**
     * Gets a console helper instance.
     */
    ConsoleHelper getConsoleHelper();

}
