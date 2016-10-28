package com.microsoft.univstore.partnercentersdk.models.subscriptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UpgradeType
{
    // -----------------------------------------------------------------------
    // <copyright file="UpgradeType.cs" company="Microsoft">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // -----------------------------------------------------------------------
    /**
     * Represents a form of upgrade for a subscription Default value
     */
    @JsonProperty( "none" ) NONE, /**
                                   * Only subscription upgrade
                                   */
    @JsonProperty( "upgrade_only" ) UPGRADE_ONLY, /**
                                                   * Subscription upgrade and license transfer
                                                   */
    @JsonProperty( "upgrade_with_license_transfer" ) UPGRADE_WITH_LICENSE_TRANSFER
}
