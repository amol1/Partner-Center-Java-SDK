package com.microsoft.univstore.partnercentersdk.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderStatus
{
    // ----------------------------------------------------------------
    // <copyright file="OrderStatus.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * Order status Indicates nothing - no status, used as an initializer
     */
    @JsonProperty( "none" ) NONE,
    /**
     * Payment issues caused this order to be abandoned
     */
    @JsonProperty( "abandones" ) ABANDONED,
    /**
     * Order declined due to payment or offer issues.
     */
    @JsonProperty( "declined" ) DECLINED,
    /**
     * Manual credit check process is in progress. Status of order will be known later.
     */
    @JsonProperty( "locked" ) LOCKED,
    /**
     * Payment reasons causes this to go to pending state.
     */
    @JsonProperty( "pending" ) PENDING, /**
                                         * Order processed.
                                         */
    @JsonProperty( "processed" ) PROCESSED, /**
                                             * Backward compatibility state.
                                             */
    @JsonProperty( "other" ) OTHER
}
