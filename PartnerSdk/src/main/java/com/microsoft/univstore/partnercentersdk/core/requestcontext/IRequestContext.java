package com.microsoft.univstore.partnercentersdk.core.requestcontext;

import java.util.UUID;

// -----------------------------------------------------------------------
// <copyright file="IRequestContext.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Bundles context information which is amended to the partner SDK operations.
 */
public interface IRequestContext
{
    /**
     * Gets the request Id. Uniquely identifies the partner service operation.
     */
    UUID getRequestId();

    /**
     * Gets the correlation Id. This Id is used to group logical operations together.
     */
    UUID getCorrelationId();

    /**
     * Gets the Locale.
     */
    String getLocale();

}
