package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

// -----------------------------------------------------------------------
// <copyright file="IPartnerServiceRequestCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of partner service requests.
 */
public interface IPartnerServiceRequestCollectionOperations
    extends IServiceRequestCollectionOperations
{
    /**
     * Gets a set of operations that can be performed on Support Topics.
     * 
     * @return Collection of Support Topic Operations.
     */
    ISupportTopicsCollectionOperations getSupportTopics();

    /**
     * Creates a new ServiceRequest.
     * 
     * @param newEntity The new ServiceRequest information.
     * @param agentLocale The locale.
     * @return The ServiceRequest information that was just created.
     */
    ServiceRequest create( ServiceRequest newEntity, String agentLocale );

}
