package com.microsoft.univstore.partnercentersdk.core.factory;

import com.microsoft.univstore.partnercentersdk.core.AggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.IAggregatePartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.IPartnerCredentials;

// -----------------------------------------------------------------------
// <copyright file="StandardPartnerFactory.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Standard implementation of the partner factory.
 */
public class StandardPartnerFactory
    implements IPartnerFactory
{
    /**
     * Builds a {@link #IAggregatePartnerOperations} instance and configures it using the provided partner credentials.
     * 
     * @param credentials The partner credentials. Use the extensions to obtain these.
     * @return A configured partner object.
     */
    @Override
    public IAggregatePartnerOperations build( IPartnerCredentials credentials )
    {
        return new AggregatePartnerOperations( credentials );
    }

}
