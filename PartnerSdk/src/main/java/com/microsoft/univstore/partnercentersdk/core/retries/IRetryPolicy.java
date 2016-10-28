package com.microsoft.univstore.partnercentersdk.core.retries;

import org.joda.time.Duration;

// -----------------------------------------------------------------------
// <copyright file="IRetryPolicy.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Defines a retry policy.
 */
public interface IRetryPolicy
{
    /**
     * Indicates whether a retry should be performed or not.
     * 
     * @param attempt The attempt number.
     * @return True to retry, false to not.
     */
    boolean shouldRetry( int attempt );

    /**
     * Indicates the time to hold off before executing the next retry.
     * 
     * @param attempt The attempt number.
     * @return The back off time.
     */
    Duration getBackOffTime( int attempt );

}
