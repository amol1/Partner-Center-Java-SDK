package com.microsoft.univstore.partnercentersdk.itest.invoices;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.invoices.Invoice;

public class InvoicePagingIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( UUID.randomUUID() ) );

        int offset = 0;
        int pageSize = 5;
        
        PagedResourceCollection<Invoice> invoiceCollection;
        
        do {
            invoiceCollection = partnerOperations.getInvoices().get( offset, pageSize );
            assertNotNull( invoiceCollection );
            assertTrue( invoiceCollection.getTotalCount() > 0 );
            assertTrue( invoiceCollection.getTotalCount() <= pageSize );
            assertNotNull( invoiceCollection.getItems().iterator().next() );
            
            offset += invoiceCollection.getTotalCount();
        } while (invoiceCollection.getLinks() != null && invoiceCollection.getLinks().getNext() != null);

    }
}
