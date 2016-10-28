package com.microsoft.univstore.partnercentersdk.core.enumerators;

import com.microsoft.univstore.partnercentersdk.core.factory.IResourceCollectionEnumeratorFactory;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

// -----------------------------------------------------------------------
// <copyright file="IResourceCollectionEnumeratorContainer.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Contains supported resource collection enumerators.
 */
public interface IResourceCollectionEnumeratorContainer
{
    /**
     * Gets a factory that creates offer collection enumerators.
     */
    IResourceCollectionEnumeratorFactory<ResourceCollection<Offer>> getOffers();

    /**
     * Gets a factory that creates customer collection enumerators.
     */
    IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<Customer>> getCustomers();

    /**
     * Gets a factory that creates invoice collection enumerators.
     */
    IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<Invoice>> getInvoices();

    /**
     * Gets a factory that creates service request collection enumerators.
     */
    IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<ServiceRequest>> getServiceRequests();

    /**
     * Gets a factory that creates invoice line item collection enumerators.
     */
    IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<InvoiceLineItem>> getInvoiceLineItems();

}
