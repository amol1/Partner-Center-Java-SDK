package com.microsoft.univstore.partnercentersdk.models.servicerequests;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ServiceRequestStatus
{
    // ----------------------------------------------------------------
    // <copyright file="ServiceRequestStatus.cs" company="Microsoft Corporation">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // ----------------------------------------------------------------
    /**
     * Describes service request status Default Service Request Status
     */
    @JsonProperty( "none" ) NONE, /**
                                   * Service Request Status Open
                                   */
    @JsonProperty( "open" ) OPEN, /**
                                   * Service Request Status Closed
                                   */
    @JsonProperty( "closed" ) CLOSED, /**
                                       * Service Request Status Action Required
                                       */
    @JsonProperty( "readyToReview" ) READY_TO_REVIEW
}
