package com.microsoft.univstore.partnercentersdk.models.query.sort;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SortDirection
{
    // -----------------------------------------------------------------------
    // <copyright file="SortDirection.cs" company="Microsoft">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // -----------------------------------------------------------------------
    /**
     * Sort direction enumeration. Ascending sort.
     */
    @JsonProperty( "ascending" ) ASCENDING, /**
                                             * Descending sort.
                                             */
    @JsonProperty( "descending" ) DESCENDING
}
