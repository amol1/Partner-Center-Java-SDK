package com.microsoft.univstore.partnercentersdk.models.query;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SeekOperation
{
    // -----------------------------------------------------------------------
    // <copyright file="SeekOperation.cs" company="Microsoft">
    // Copyright (c) Microsoft Corporation. All rights reserved.
    // </copyright>
    // -----------------------------------------------------------------------
    /**
     * Specifies how to seek a query. Gets the next set of results.
     */
    @JsonProperty( "Next" ) NEXT, /**
           * Gets the previous set of results.
           */
    @JsonProperty( "Previous" ) PREVIOUS, /**
               * Gets the first set of results.
               */
    @JsonProperty( "First" ) FIRST, /**
            * Gets the last set of results.
            */
    @JsonProperty( "Last" ) LAST, /**
           * Gets a set of results using a page index. E.g. Get the seventh set of results.
           */
    @JsonProperty( "PageIndex" ) PAGE_INDEX
}
