package com.microsoft.univstore.partnercentersdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ContractType
{
    // ----------------------------------------------------------------
    // <copyright file="ContractType.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * Describes the type of contract Refers to a contract which provides subscription for the order item placed
     */
    @JsonProperty( "subscription" ) SUBSCRIPTION,
    /**
     * Refers to a contract which provides a product key result for the order item placed
     */
    @JsonProperty( "productkey" ) PRODUCTKEY,
    /**
     * Refers to a contract which provides Redemption code result for the order item placed.
     */
    @JsonProperty( "redemptioncode" ) REDEMPTIONCODE
}
