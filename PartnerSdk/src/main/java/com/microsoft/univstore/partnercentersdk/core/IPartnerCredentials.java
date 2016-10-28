package com.microsoft.univstore.partnercentersdk.core;

import org.joda.time.DateTime;

import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;

// -----------------------------------------------------------------------
// <copyright file="IPartnerCredentials.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The credentials needed to access the partner API service.
 */
public interface IPartnerCredentials
{
    /**
     * Gets the token needed to authenticate with the partner API service.
     */
    String getPartnerServiceToken();

    /**
     * Gets the expiry time in UTC for the token.
     */
    DateTime getExpiresAt();

    /**
     * Indicates whether the partner credentials have expired or not.
     * 
     * @return True if credentials have expired. False if not.
     */
    boolean isExpired();

    void onCredentialsRefreshNeeded( IPartnerCredentials credentials, IRequestContext context );

}
