package com.microsoft.univstore.partnercentersdk.core;

import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;

// -----------------------------------------------------------------------
// <copyright file="AggregatePartnerOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Aggregate partner implementation.
 */
public class AggregatePartnerOperations
    extends PartnerOperations
    implements IAggregatePartnerOperations
{
    /**
     * Initializes a new instance of the {@link #AggregatePartnerOperations} class.
     * 
     * @param credentials The partner credentials.
     */
    public AggregatePartnerOperations( IPartnerCredentials credentials )
    {
        super( credentials, RequestContextFactory.create() );
    }

    /**
     * Returns a partner operations object which uses the provided context when executing operations.
     * 
     * @param context An operation context object.
     * @return A partner operations object which uses the provided operation context.
     */
    @Override
    public IPartnerOperations with( IRequestContext context )
    {
        if ( context == null )
        {
            throw new IllegalArgumentException( "context null" );
        }

        return new PartnerOperations( this.getCredentials(), context );
    }

}
