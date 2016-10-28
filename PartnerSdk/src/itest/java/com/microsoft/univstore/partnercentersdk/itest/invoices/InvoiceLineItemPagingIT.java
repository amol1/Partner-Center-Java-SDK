package com.microsoft.univstore.partnercentersdk.itest.invoices;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceDetail;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;

public class InvoiceLineItemPagingIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( UUID.randomUUID() ) );

        ResourceCollection<Invoice> invoiceCollection = partnerOperations.getInvoices().get();
        assertNotNull( invoiceCollection );
        assertTrue( invoiceCollection.getTotalCount() > 0 );

        int offset = 0;
        int pageSize = 5;

        ResourceCollection<InvoiceLineItem> lineItemCollection = null;
        InvoiceDetail invoiceDetail = null;
        Invoice invoice = null;

        for ( Invoice invoiceTry : invoiceCollection.getItems() )
        {
            for ( InvoiceDetail invoiceDetailTry : invoiceTry.getInvoiceDetails() )
            {
                PagedResourceCollection<InvoiceLineItem> lineItemCollectionTry =
                    partnerOperations.getInvoices().byId( invoiceTry.getId() ).getInvoiceLineItems( invoiceDetailTry.getBillingProvider(),
                                                                                                 invoiceDetailTry.getInvoiceLineItemType(),
                                                                                                 offset, pageSize );
                assertNotNull( lineItemCollectionTry );
                if ( lineItemCollectionTry.getTotalCount() > 0 )
                {
                    lineItemCollection = lineItemCollectionTry;
                    invoiceDetail = invoiceDetailTry;
                    invoice = invoiceTry;
                    break;
                }
            }
            if (lineItemCollection != null)
            {
                break;
            }
        }

        assertNotNull("No non empty line item collection was found", lineItemCollection);        
        
        do
        {
            lineItemCollection =
                            partnerOperations.getInvoices().byId( invoice.getId() ).getInvoiceLineItems( invoiceDetail.getBillingProvider(),
                                                                                                         invoiceDetail.getInvoiceLineItemType(),
                                                                                                         offset, pageSize );

            assertTrue( lineItemCollection.getTotalCount() <= pageSize );
            assertNotNull( lineItemCollection.getItems().iterator().next() );

            offset += lineItemCollection.getTotalCount();
        }
        while ( lineItemCollection.getLinks() != null && lineItemCollection.getLinks().getNext() != null );

    }
}
