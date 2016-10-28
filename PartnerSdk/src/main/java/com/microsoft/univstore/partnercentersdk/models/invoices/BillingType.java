package com.microsoft.univstore.partnercentersdk.models.invoices;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BillingType
{
    // ----------------------------------------------------------------
    // <copyright file="BillingType.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * The way billing is processed for a subscription Indicates nothing - not set, used as an initializer
     */
    @JsonProperty( "none" ) NONE, /**
                                   * The usage based billing
                                   */
    @JsonProperty( "usage" ) USAGE, /**
                                     * The license based billing
                                     */
    @JsonProperty( "license" ) LICENSE
}
