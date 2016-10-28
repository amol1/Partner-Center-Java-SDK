package com.microsoft.univstore.partnercentersdk.core;

import com.microsoft.univstore.partnercentersdk.core.customers.ICustomerCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.enumerators.IResourceCollectionEnumeratorContainer;
import com.microsoft.univstore.partnercentersdk.core.invoices.IInvoiceCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.offers.IOfferCategoryCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.offers.IOfferCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.profiles.IPartnerProfileCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.core.servicerequests.IPartnerServiceRequestCollectionOperations;
import com.microsoft.univstore.partnercentersdk.core.usage.IPartnerUsageSummaryOperations;
import com.microsoft.univstore.partnercentersdk.core.validations.IValidationOperations;

// -----------------------------------------------------------------------
// <copyright file="IPartnerOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The main entry point into using the partner SDK functionality. Represents a partner and encapsulates all the behavior
 * attached to partners. Use this interface to get to the partner's customers, profiles, and customer orders, profiles
 * and subscriptions and more.
 */
public interface IPartnerOperations
{
    /**
     * Gets the partner credentials.
     */
    IPartnerCredentials getCredentials();

    /**
     * Gets the partner context.
     */
    IRequestContext getRequestContext();

    /**
     * Gets the collection enumerators available for traversing through results.
     */
    IResourceCollectionEnumeratorContainer getEnumerators();

    /**
     * Gets the offer categories operations available to the partner.
     */
    IOfferCategoryCollectionOperations getOfferCategories();

    /**
     * Gets the offer operations available to the partner
     */
    IOfferCollectionOperations getOffers();

    /**
     * Gets the profiles operations available to the partner.
     */
    IPartnerProfileCollectionOperations getProfiles();

    /**
     * Gets the partner customers operations.
     */
    ICustomerCollectionOperations getCustomers();

    /**
     * Gets the partner's invoices.
     */
    IInvoiceCollectionOperations getInvoices();

    /**
     * Gets the operations that can be performed on a partners' service requests
     */
    IPartnerServiceRequestCollectionOperations getServiceRequests();

    /**
     * Gets the validation operations available to the partner.
     */
    IValidationOperations getValidations();

    /**
     * Gets the usage summary operations available to the partner.
     */
    IPartnerUsageSummaryOperations getUsageSummary();

}
