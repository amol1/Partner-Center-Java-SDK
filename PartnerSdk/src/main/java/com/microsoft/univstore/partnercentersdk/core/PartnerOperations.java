package com.microsoft.univstore.partnercentersdk.core;

import com.microsoft.univstore.partnercentersdk.core.customers.CustomerCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.customers.ICustomerCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumeratorContainer;
import com.microsoft.univstore.partnercentersdk.core.enumerators.ResourceCollectionEnumeratorContainer;
import com.microsoft.univstore.partnercentersdk.core.invoices.IInvoiceCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.invoices.InvoiceCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.offers.IOfferCategoryCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.offers.IOfferCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.offers.OfferCategoryCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.offers.OfferCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.profiles.IPartnerProfileCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.profiles.PartnerProfileCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.servicerequests.IPartnerServiceRequestCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.servicerequests.PartnerServiceRequestCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.usage.IPartnerUsageSummaryOperations;
import com.microsoft.univstore.partnercentersdk.core.usage.PartnerUsageSummaryOperations;
import com.microsoft.univstore.partnercentersdk.core.validations.IValidationOperations;
import com.microsoft.univstore.partnercentersdk.core.validations.ValidationOperations;

// -----------------------------------------------------------------------
// <copyright file="PartnerOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner implementation class.
 */
public class PartnerOperations
    implements IPartnerOperations
{
    // /**
    // * The resource collection enumerator container.
    // */
    private IResourceCollectionEnumeratorContainer enumeratorContainer;

    /**
     * The partner customers operations.
     */
    private ICustomerCollectionOperations customers;

    /**
     * The offer categories.
     */
    private IOfferCategoryCollectionOperations offerCategories;

    /**
     * The offers operation.
     */
    private IOfferCollectionOperations offers;

    /**
     * The profile operations.
     */
    private IPartnerProfileCollectionOperations profiles;

    /**
     * The partner invoices.
     */
    private IInvoiceCollectionOperations invoices;

    /**
     * The service request operations.
     */
    private IPartnerServiceRequestCollectionOperations serviceRequests;

    /**
     * The validations operations.
     */
    private IValidationOperations validations;

    /**
     * Gets the usage summary operations available to the partner.
     */
    private IPartnerUsageSummaryOperations usageSummary;

    /**
     * Initializes a new instance of the {@link #PartnerOperations} class.
     * 
     * @param credentials The partner credentials.
     * @param context A partner context.
     */
    public PartnerOperations( IPartnerCredentials credentials, IRequestContext context )
    {
        if ( credentials == null )
        {
            throw new IllegalArgumentException( "credentials can't be null" );
        }
        if ( context == null )
        {
            throw new IllegalArgumentException( "context can't be null" );
        }
        this.setCredentials( credentials );
        this.setRequestContext( context );
    }

    /**
     * Gets the partner credentials.
     */
    private IPartnerCredentials __Credentials;

    @Override
    public IPartnerCredentials getCredentials()
    {
        return __Credentials;
    }

    private void setCredentials( IPartnerCredentials value )
    {
        __Credentials = value;
    }

    /**
     * Gets the partner context.
     */
    private IRequestContext __RequestContext;

    @Override
    public IRequestContext getRequestContext()
    {
        return __RequestContext;
    }

    private void setRequestContext( IRequestContext value )
    {
        __RequestContext = value;
    }

    /**
     * Gets the collection enumerators available for traversing through results.
     */
    @Override
    public IResourceCollectionEnumeratorContainer getEnumerators()
    {
        if ( this.enumeratorContainer == null )
        {
            this.enumeratorContainer = new ResourceCollectionEnumeratorContainer( this );
        }
        return this.enumeratorContainer;
    }

    /**
     * Gets the offer categories operations available to the partner.
     */
    @Override
    public IOfferCategoryCollectionOperations getOfferCategories()
    {
        if ( this.offerCategories == null )
        {
            this.offerCategories = new OfferCategoryCollectionOperations( this );
        }
        return this.offerCategories;
    }

    /**
     * Gets the partner profiles operations.
     */
    @Override
    public IPartnerProfileCollectionOperations getProfiles()
    {

        if ( this.profiles == null )
        {
            this.profiles = new PartnerProfileCollectionOperations( this );
        }
        return this.profiles;
    }

    /**
     * Gets the partner customers operations.
     */
    @Override
    public ICustomerCollectionOperations getCustomers()
    {
        if ( this.customers == null )
        {
            this.customers = new CustomerCollectionOperations( this );
        }
        return this.customers;
    }

    /**
     * Gets the offer operations available to the partner.
     */
    @Override
    public IOfferCollectionOperations getOffers()
    {
        if ( this.offers == null )
        {
            this.offers = new OfferCollectionOperations( this );
        }
        return this.offers;
    }

    /**
     * Gets the partner's invoices.
     */
    @Override
    public IInvoiceCollectionOperations getInvoices()
    {
        if ( this.invoices == null )
        {
            this.invoices = new InvoiceCollectionOperations( this );
        }
        return this.invoices;
    }

    /**
     * Gets the Service Request operations available.
     */
    @Override
    public IPartnerServiceRequestCollectionOperations getServiceRequests()
    {
        if ( this.serviceRequests == null )
        {
            this.serviceRequests = new PartnerServiceRequestCollectionOperations( this );
        }
        return this.serviceRequests;
    }

    /**
     * Gets the Validation operations available.
     */
    @Override
    public IValidationOperations getValidations()
    {
        if ( this.validations == null )
        {
            this.validations = new ValidationOperations( this );
        }
        return this.validations;
    }

    /**
     * Gets the usage summary operations available to the partner.
     */
    @Override
    public IPartnerUsageSummaryOperations getUsageSummary()
    {
        if ( this.usageSummary == null )
        {
            this.usageSummary = new PartnerUsageSummaryOperations( this );
        }
        return this.usageSummary;
    }

}
