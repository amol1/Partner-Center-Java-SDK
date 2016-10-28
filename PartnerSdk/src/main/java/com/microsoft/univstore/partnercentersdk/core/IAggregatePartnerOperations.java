package com.microsoft.univstore.partnercentersdk.core;

import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;

// -----------------------------------------------------------------------
// <copyright file="IAggregatePartnerOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A partner operations interface which can be used to generate scoped partner operations that use a specific partner
 * context.
 */
public interface IAggregatePartnerOperations
    extends IPartnerOperations
{
    /**
     * Returns a partner operations object which uses the provided context when executing operations.
     * 
     * @param context An operation context object.
     * @return A partner operations object which uses the provided operation context.
     */
    IPartnerOperations with( IRequestContext context );

}
