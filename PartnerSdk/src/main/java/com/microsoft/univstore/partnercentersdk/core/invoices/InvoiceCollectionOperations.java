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
import com.microsoft.univstore.partnercentersdk.models.invoices.Summary;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;

// -----------------------------------------------------------------------
// <copyright file="InvoiceCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents the operations that can be done on Partner's invoices
 */
public class InvoiceCollectionOperations
    extends BasePartnerComponentString
    implements IInvoiceCollectionOperations
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
     * Initializes a new instance of the {@link #InvoiceCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public InvoiceCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Gets a single invoice operations.
     * 
     * @param invoiceId The invoice id.
     * @return The invoice operations.
     */
    @Override
    public IInvoiceOperations byId( String invoiceId )
    {
        if ( StringHelper.isNullOrWhiteSpace( invoiceId ) )
        {
            throw new IllegalArgumentException( "invoiceId has to be set." );
        }
        return new InvoiceOperations( this.getPartner(), invoiceId );
    }

    /**
     * Retrieves the partner's current account balance.
     * 
     * @return The account balance.
     */
    @Override
    public Summary getInvoiceSummary()
    {
        IPartnerServiceProxy<Summary, Summary> partnerServiceProxy =
            new PartnerServiceProxy<Summary, Summary>( new TypeReference<Summary>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoiceSummary" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Retrieves all invoices associated to the partner.
     * 
     * @return The collection of invoices.
     */
    @Override
    public SeekBasedResourceCollection<Invoice> get()
    {
        IPartnerServiceProxy<Invoice, SeekBasedResourceCollection<Invoice>> partnerServiceProxy =
            new PartnerServiceProxy<Invoice, SeekBasedResourceCollection<Invoice>>( new TypeReference<SeekBasedResourceCollection<Invoice>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoices" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Retrieves all invoices associated to the partner.
     * 
     * @param offset The page offset.
     * @param size The maximum number of invoices to return.
     * @return The subset of invoices.
     */
    @Override
    public SeekBasedResourceCollection<Invoice> get( int offset, int size )
    {
        ParameterValidator.isIntInclusive( 0, Integer.MAX_VALUE, offset,
                                           "The value of the page offset should be at least 0." );
        ParameterValidator.isIntInclusive( MinPageSize, MaxPageSize, size,
                                           MessageFormat.format( "The page size must be an integer within the allowed range: {0}-{1}.",
                                                                 MinPageSize, MaxPageSize ) );
        IPartnerServiceProxy<Invoice, SeekBasedResourceCollection<Invoice>> partnerServiceProxy =
            new PartnerServiceProxy<Invoice, SeekBasedResourceCollection<Invoice>>( new TypeReference<SeekBasedResourceCollection<Invoice>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoices" ).getPath(),
                                                        Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoices" ).getParameters().get( "Offset" ),
                                                                                      String.valueOf( offset ) ) );
        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetInvoices" ).getParameters().get( "Size" ),
                                                                                      String.valueOf( size ) ) );

        return partnerServiceProxy.get();
    }

}
