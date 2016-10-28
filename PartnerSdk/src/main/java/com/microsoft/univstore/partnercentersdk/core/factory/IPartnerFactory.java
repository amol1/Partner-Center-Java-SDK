package com.microsoft.univstore.partnercentersdk.core.factory;

import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;

// -----------------------------------------------------------------------
// <copyright file="IPartnerFactory.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Creates instances of {@link #IPartnerOperations} .
 */
public interface IPartnerFactory
{
    /**
     * Builds a {@link #IAggregatePartnerOperations} instance and configures it using the provided partner credentials.
     * 
     * @param credentials The partner credentials. Use the extensions to obtain these.
     * @return A configured partner object.
     */
    IAggregatePartnerOperations build( IPartnerCredentials credentials );

}