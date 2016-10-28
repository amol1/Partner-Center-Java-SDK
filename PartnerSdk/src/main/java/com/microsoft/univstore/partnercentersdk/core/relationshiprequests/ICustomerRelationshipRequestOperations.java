package com.microsoft.univstore.partnercentersdk.core.relationshiprequests;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.models.relationshiprequests.CustomerRelationshipRequest;

// -----------------------------------------------------------------------
// <copyright file="ICustomerRelationshipRequestOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Holds operations that apply to customer relationship requests.
 */
public interface ICustomerRelationshipRequestOperations
    extends IPartnerComponentString, IEntityGetOperations<CustomerRelationshipRequest>
{
    /**
     * Retrieves the customer relationship request which can be used by a customer to establish a relationship with the
     * current partner.
     * 
     * @return A customer relationship request.
     */
    CustomerRelationshipRequest get();

}
