package com.microsoft.univstore.partnercentersdk.models.subscriptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SubscriptionStatus
{
    // ----------------------------------------------------------------
    // <copyright file="SubscriptionStatus.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * Enum representing the available states for a subscription Indicates nothing - no status, used as an initializer
     */
    @JsonProperty( "none" ) NONE, /**
                                   * Subscription state: Active
                                   */
    @JsonProperty( "active" ) ACTIVE, /**
                                       * Subscription state: Suspended
                                       */
    @JsonProperty( "suspended" ) SUSPENDED, /**
                                             * Subscription state: Deleted
                                             */
    @JsonProperty( "deleted" ) DELETED
}
