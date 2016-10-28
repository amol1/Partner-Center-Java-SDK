package com.microsoft.univstore.partnercentersdk.core.errorhandling;

import org.apache.http.HttpResponse;

import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;

// -----------------------------------------------------------------------
// <copyright file="IFailedPartnerServiceResponseHandler.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines behavior for handling non successful responses from the partner service.
 */
public interface IFailedPartnerServiceResponseHandler
{
    /**
     * Handles failed partner service responses.
     * 
     * @param response The partner service response.
     * @param context An optional partner context.
     * @return The exception to throw.
     */
    PartnerException handleFailedResponse( HttpResponse response );

    PartnerException handleFailedResponse( HttpResponse response, IRequestContext context );

}
