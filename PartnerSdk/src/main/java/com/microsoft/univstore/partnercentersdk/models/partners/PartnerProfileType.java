package com.microsoft.univstore.partnercentersdk.models.partners;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PartnerProfileType
{
    // ----------------------------------------------------------------
    // <copyright file="PartnerProfileType.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * Types partner profile supported The partner's Microsoft Partner Network profile
     */
    @JsonProperty( "PartnerNetworkProfile" ) PARTNER_NETWORK_PROFILE, /**
                                                                       * The partner's partner billing profile
                                                                       */
    @JsonProperty( "PartnerBillingProfile" ) PARTNER_BILLING_PROFILE, /**
                                                                       * The partner's support profile
                                                                       */
    @JsonProperty( "support_profile" ) SUPPORT_PROFILE, /**
                                                         * The partner's legal business profile
                                                         */
    @JsonProperty( "LegalBusinessProfile" ) LEGAL_BUSINESS_PROFILE, /**
                                                                     * The partner's organization profile
                                                                     */
    @JsonProperty( "OrganizationProfile" ) ORGANIZATION_PROFILE
}
