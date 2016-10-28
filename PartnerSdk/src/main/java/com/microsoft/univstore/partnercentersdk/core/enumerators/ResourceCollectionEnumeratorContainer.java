package com.microsoft.univstore.partnercentersdk.core.enumerators;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.factory.IResourceCollectionEnumeratorFactory;
import com.microsoft.univstore.partnercentersdk.core.factory.IndexBasedCollectionEnumeratorFactory;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.servicerequests.ServiceRequest;

// -----------------------------------------------------------------------
// <copyright file="ResourceCollectionEnumeratorContainer.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Contains supported resource collection enumerators.
 */
public class ResourceCollectionEnumeratorContainer
    extends BasePartnerComponentString
    implements IResourceCollectionEnumeratorContainer
{
    /**
     * A lazy reference to an offer enumerator factory.
     */
    private IndexBasedCollectionEnumeratorFactory<Offer, ResourceCollection<Offer>> offerEnumeratorFactory;

    /**
     * A lazy reference to a customer enumerator factory.
     */
    private IndexBasedCollectionEnumeratorFactory<Customer, SeekBasedResourceCollection<Customer>> customerEnumeratorFactory;

    /**
     * A lazy reference to an invoice enumerator factory.
     */
    private IndexBasedCollectionEnumeratorFactory<Invoice, SeekBasedResourceCollection<Invoice>> invoiceEnumeratorFactory;

    /**
     * A lazy reference to a service request enumerator factory.
     */
    private IndexBasedCollectionEnumeratorFactory<ServiceRequest, SeekBasedResourceCollection<ServiceRequest>> serviceRequestEnumeratorFactory;

    /**
     * A lazy reference to an invoice line enumerator factory.
     */
    private IndexBasedCollectionEnumeratorFactory<InvoiceLineItem, SeekBasedResourceCollection<InvoiceLineItem>> invoiceLineItemEnumeratorFactory;

    /**
     * Initializes a new instance of the {@link #ResourceCollectionEnumeratorContainer} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public ResourceCollectionEnumeratorContainer( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Gets a factory that creates offer collection enumerators.
     */
    @Override
    public IResourceCollectionEnumeratorFactory<ResourceCollection<Offer>> getOffers()
    {
        if ( this.offerEnumeratorFactory == null )
        {
            this.offerEnumeratorFactory =
                new IndexBasedCollectionEnumeratorFactory<Offer, ResourceCollection<Offer>>( this.getPartner(),
                                                                                             new TypeReference<ResourceCollection<Offer>>()
                                                                                             {
                                                                                             } );
        }
        return this.offerEnumeratorFactory;
    }

    /**
     * Gets a factory that creates customer collection enumerators.
     */
    @Override
    public IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<Customer>> getCustomers()
    {
        if ( this.customerEnumeratorFactory == null )
        {
            this.customerEnumeratorFactory =
                new IndexBasedCollectionEnumeratorFactory<Customer, SeekBasedResourceCollection<Customer>>( this.getPartner(),
                                                                                                        new TypeReference<SeekBasedResourceCollection<Customer>>()
                                                                                                        {
                                                                                                        } );
        }
        return this.customerEnumeratorFactory;
    }

    /**
     * Gets a factory that creates invoice collection enumerators.
     */
    @Override
    public IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<Invoice>> getInvoices()
    {
        if ( this.invoiceEnumeratorFactory == null )
        {
            this.invoiceEnumeratorFactory =
                new IndexBasedCollectionEnumeratorFactory<Invoice, SeekBasedResourceCollection<Invoice>>( this.getPartner(),
                                                                                                      new TypeReference<SeekBasedResourceCollection<Invoice>>()
                                                                                                      {
                                                                                                      } );
        }
        return this.invoiceEnumeratorFactory;
    }

    /**
     * Gets a factory that creates service request collection enumerators.
     */
    @Override
    public IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<ServiceRequest>> getServiceRequests()
    {
        if ( this.serviceRequestEnumeratorFactory == null )
        {
            this.serviceRequestEnumeratorFactory =
                new IndexBasedCollectionEnumeratorFactory<ServiceRequest, SeekBasedResourceCollection<ServiceRequest>>( this.getPartner(),
                                                                                                                    new TypeReference<SeekBasedResourceCollection<ServiceRequest>>()
                                                                                                                    {
                                                                                                                    } );
        }
        return this.serviceRequestEnumeratorFactory;
    }

    /**
     * Gets a factory that creates invoice line item collection enumerators.
     */
    @Override
    public IResourceCollectionEnumeratorFactory<SeekBasedResourceCollection<InvoiceLineItem>> getInvoiceLineItems()
    {
        if ( this.invoiceLineItemEnumeratorFactory == null )
        {
            this.invoiceLineItemEnumeratorFactory =
                new IndexBasedCollectionEnumeratorFactory<InvoiceLineItem, SeekBasedResourceCollection<InvoiceLineItem>>( this.getPartner(),
                                                                                                                      new TypeReference<SeekBasedResourceCollection<InvoiceLineItem>>()
                                                                                                                      {
                                                                                                                      } );
        }
        return this.invoiceLineItemEnumeratorFactory;
    }

}
