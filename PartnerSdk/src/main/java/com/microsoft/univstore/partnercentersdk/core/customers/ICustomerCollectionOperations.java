package com.microsoft.univstore.partnercentersdk.core.customers;

import com.microsoft.univstore.partnercentersdk.core.IPartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCreateOperations;
import com.microsoft.univstore.partnercentersdk.core.relationshiprequests.ICustomerRelationshipRequestOperations;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.query.IQuery;

// -----------------------------------------------------------------------
// <copyright file="ICustomerCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the behavior of the partner customers.
 */
public interface ICustomerCollectionOperations
    extends IPartnerComponentString, IEntityCreateOperations<Customer, Customer>,
    IEntireEntityCollectionRetrievalOperations<Customer, SeekBasedResourceCollection<Customer>>
{

    /**
     * Gets the customer usage record operations.
     */
    ICustomerUsageRecordCollectionOperations getUsageRecords();

    /**
     * Gets the customer relationship request operations.
     */
    ICustomerRelationshipRequestOperations getRelationshipRequests();

    /**
     * Gets a single customer operations.
     * 
     * @param customerId The customer id.
     * @return The customer operations.
     */
    ICustomerOperations byId( String customerId );

    /**
     * Queries customers associated to the partner. - Count queries are not supported by this operation. - You can set
     * the page size or filter or do both at the same time. - Sort is not supported. - You can navigate to other pages
     * by specifying a seek query with the seek operation and the continuation token sent by the previous operation.
     * 
     * @param customersQuery A query to apply onto customers. Check {@link #QueryFactory} to see how to build queries.
     * @return The requested customers.
     */
    SeekBasedResourceCollection<Customer> query( IQuery customersQuery );

}
