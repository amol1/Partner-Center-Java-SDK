package com.microsoft.univstore.partnercentersdk.core;

// -----------------------------------------------------------------------
// <copyright file="BasePartnerComponent.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Holds common partner component properties and behavior. The context is string type by default.
 */
public abstract class BasePartnerComponentString
    extends BasePartnerComponent<String>
{

    protected BasePartnerComponentString( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations, null );
    }

    /**
     * Initializes a new instance of the {@link #BasePartnerComponent} class.
     * 
     * @param rootPartnerOperations The root partner operations that created this component.
     * @param componentContext A component context object to work with.
     */
    protected BasePartnerComponentString( IPartnerOperations rootPartnerOperations, String componentContext )
    {
        super( rootPartnerOperations, componentContext );
    }

}
