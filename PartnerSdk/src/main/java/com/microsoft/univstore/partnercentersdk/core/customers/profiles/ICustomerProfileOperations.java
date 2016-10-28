package com.microsoft.univstore.partnercentersdk.core.customers.profiles;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityGetOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityUpdateOperations;
import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="ICustomerProfileOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Encapsulates a single customer profile behavior. The type of the customer profile.
 */
public interface ICustomerProfileOperations<T extends ResourceBase>
    extends IPartnerComponentString, IEntityGetOperations<T>, IEntityUpdateOperations<T>
{
}
