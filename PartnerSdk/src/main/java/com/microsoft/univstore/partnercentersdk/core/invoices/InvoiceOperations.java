package com.microsoft.univstore.partnercentersdk.core.invoices;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.ParameterValidator;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.SeekBasedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.BillingProvider;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItemType;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="InvoiceOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Operations available for the reseller's invoice.
 */
public class InvoiceOperations
    extends BasePartnerComponentString
    implements IInvoiceOperations
{
    /**
     * The maximum allowed page size
     */
    private static final int MaxPageSize = 200;

    /**
     * The minimum allowed page size
     */
    private static final int MinPageSize = 1;

    /**
     * Initializes a new instance of the {@link #InvoiceOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param invoiceId The invoice id.
     */
    public InvoiceOperations( IPartnerOperations rootPartnerOperations, String invoiceId )
    {
        super( rootPartnerOperations, invoiceId );
        if ( StringHelper.isNullOrWhiteSpace( invoiceId ) )
        {
            throw new IllegalArgumentException( "invoiceId has to be set." );
        }
    }

    /**
     * Retrieves information about a specific invoice.
     * 
     * @return The invoice.
     */
    @Override
    public Invoice get()
    {
        IPartnerServiceProxy<Invoice, Invoice> partnerServiceProxy =
            new PartnerServiceProxy<Invoice, Invoice>( new TypeReference<Invoice>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoice" ).getPath(),
                                                        this.getContext(), Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Retrieves invoice line items for a specific billing provider and invoice line item type
     * 
     * @param billingProvider The provider of billing information,
     * @param invoiceLineItemType The type of invoice line item.
     * @return The collection of invoice line items.
     */
    @Override
    public SeekBasedResourceCollection<InvoiceLineItem> getInvoiceLineItems( BillingProvider billingProvider,
                                                                         InvoiceLineItemType invoiceLineItemType )
    {
        IPartnerServiceProxy<InvoiceLineItem, SeekBasedResourceCollection<InvoiceLineItem>> partnerServiceProxy =
            new PartnerServiceProxy<InvoiceLineItem, SeekBasedResourceCollection<InvoiceLineItem>>( new TypeReference<SeekBasedResourceCollection<InvoiceLineItem>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoiceLineItems" ).getPath(),
                                                        this.getContext(), billingProvider,
                                                        invoiceLineItemType.getUrlName(), Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Retrieves a subset of invoice line items for a specific billing provider and invoice line item type
     * 
     * @param billingProvider The provider of billing information,
     * @param invoiceLineItemType The type of invoice line item.
     * @param size The maximum number of invoice line items to return.
     * @param offset The page offset.
     * @return The subset of invoice line items.
     */
    @Override
    public SeekBasedResourceCollection<InvoiceLineItem> getInvoiceLineItems( BillingProvider billingProvider,
                                                                         InvoiceLineItemType invoiceLineItemType,
                                                                         int offset, int size )
    {
        ParameterValidator.isIntInclusive( 0, Integer.MAX_VALUE, offset, "offset has to be non-negative." );
        ParameterValidator.isIntInclusive( MinPageSize, MaxPageSize, size,
                                           MessageFormat.format( "The page size must be an integer within the allowed range: {0}-{1}.",
                                                                 MinPageSize, MaxPageSize ) );
        IPartnerServiceProxy<InvoiceLineItem, SeekBasedResourceCollection<InvoiceLineItem>> partnerServiceProxy =
            new PartnerServiceProxy<InvoiceLineItem, SeekBasedResourceCollection<InvoiceLineItem>>( new TypeReference<SeekBasedResourceCollection<InvoiceLineItem>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoiceLineItems" ).getPath(),
                                                        this.getContext(),
                                                        String.valueOf( billingProvider ).toLowerCase(),
                                                        invoiceLineItemType.getUrlName(), Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoiceLineItems" ).getParameters().get( "Offset" ),
                                                                                      String.valueOf( offset ) ) );
        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoiceLineItems" ).getParameters().get( "Size" ),
                                                                                      String.valueOf( size ) ) );

        return partnerServiceProxy.get();
    }

}
