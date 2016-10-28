package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.query.IQuery;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

// -----------------------------------------------------------------------
// <copyright file="IServiceRequestCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of service requests.
 */
public interface IServiceRequestCollectionOperations
    extends IPartnerComponentString,
    IEntireEntityCollectionRetrievalOperations<ServiceRequest, ResourceCollection<ServiceRequest>>
{
    /**
     * Gets a single service request
     * 
     * @param serviceRequestId Service Request Id
     * @return The service request operations.
     */
    IServiceRequestOperations byId( String serviceRequestId );

    /**
     * Queries service requests associated to an organization. - Count queries are not supported by this operation. -
     * You can set the page size or filter or do both at the same time. - Sort is not supported. Default sorting is on
     * status field
     * 
     * @param serviceRequestsQuery A query to apply onto service requests. Check {@link #QueryFactory} to see how to
     *            build queries.
     * @return The requested service requests.
     */
    SeekBasedResourceCollection<ServiceRequest> query( IQuery serviceRequestsQuery );

}
