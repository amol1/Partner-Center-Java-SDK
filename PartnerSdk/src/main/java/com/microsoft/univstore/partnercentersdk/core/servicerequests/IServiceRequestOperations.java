package com.microsoft.univstore.partnercentersdk.core.servicerequests;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="IServiceRequestOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Groups operations that can be performed on a single service request.
 */
public interface IServiceRequestOperations
    extends IPartnerComponent<Tuple<String, String>>, IEntityGetOperations<ServiceRequest>,
    IEntityUpdateOperations<ServiceRequest>
{
}
