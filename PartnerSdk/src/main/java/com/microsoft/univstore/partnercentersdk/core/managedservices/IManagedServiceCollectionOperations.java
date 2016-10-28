package com.microsoft.univstore.partnercentersdk.core.managedservices;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.ManagedService;

// -----------------------------------------------------------------------
// <copyright file="IManagedServiceCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Holds the customer's managed services operations.
 */
public interface IManagedServiceCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<ManagedService, ResourceCollection<ManagedService>>
{
    /**
     * Retrieves all managed services. This operation is currently only supported for user based credentials.
     * 
     * @return The managed services.
     */
    ResourceCollection<ManagedService> get();

}
