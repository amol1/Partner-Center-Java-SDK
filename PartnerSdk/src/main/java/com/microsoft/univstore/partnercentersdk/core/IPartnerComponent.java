package com.microsoft.univstore.partnercentersdk.core;

// -----------------------------------------------------------------------
// <copyright file="IPartnerComponent.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents a partner SDK component. The type of the component's context object.
 */
public interface IPartnerComponent<TContext>
{
    /**
     * Gets a reference to the partner operations instance that generated this component.
     */
    IPartnerOperations getPartner();

    /**
     * Gets the component context object.
     */
    TContext getContext();

}