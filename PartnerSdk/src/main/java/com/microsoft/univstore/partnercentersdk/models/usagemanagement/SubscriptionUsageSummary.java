package com.microsoft.univstore.partnercentersdk.models.usagemanagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// -----------------------------------------------------------------------
// <copyright file="SubscriptionUsageSummary.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class defines the usage summary for a specific subscription.
 */
@JsonIgnoreProperties( "lastModifiedDate" )
public class SubscriptionUsageSummary
    extends UsageSummaryBase
{
}