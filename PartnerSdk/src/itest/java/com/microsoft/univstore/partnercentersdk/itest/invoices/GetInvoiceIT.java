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

public class GetInvoiceIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( UUID.randomUUID() ) );

        PagedResourceCollection<Invoice> invoiceCollection = partnerOperations.getInvoices().get( 0, 1 );
                
        assertNotNull( invoiceCollection );
        assertTrue( invoiceCollection.getTotalCount() > 0 );
        
        Invoice selectedInvoice = invoiceCollection.getItems().iterator().next();
        assertNotNull(selectedInvoice);
        
        Invoice queriedInvoice = partnerOperations.getInvoices().byId( selectedInvoice.getId() ).get();
        
        assertNotNull(queriedInvoice);
        assertNotNull(queriedInvoice.getAttributes());
        //assertNotNull(queriedInvoice.getAttributes().getEtag());
        assertNotNull(queriedInvoice.getAttributes().getObjectType());
        assertNotNull(queriedInvoice.getCurrencyCode());
        assertNotNull(queriedInvoice.getId());
        assertNotNull(queriedInvoice.getInvoiceDate());
        assertNotNull(queriedInvoice.getInvoiceDetails());
        assertNotNull(queriedInvoice.getLinks());
        assertNotNull(queriedInvoice.getLinks().getSelf());
        assertNotNull(queriedInvoice.getPaidAmount());
        assertNotNull(queriedInvoice.getPdfDownloadLink());
        assertNotNull(queriedInvoice.getTotalCharges());

    }
}
