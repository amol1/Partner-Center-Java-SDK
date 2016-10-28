package com.microsoft.univstore.partnercentersdk.itest.invoices;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.invoices.Summary;

public class GetInvoiceSummaryIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( UUID.randomUUID() ) );

        Summary balance = partnerOperations.getInvoices().getInvoiceSummary();
        
        assertNotNull(balance);
        assertNotNull(balance.getAccountingDate());
        assertNotNull(balance.getAttributes());
        //assertNotNull(balance.getAttributes().getEtag());
        assertNotNull(balance.getAttributes().getObjectType());
        assertNotNull(balance.getCurrencyCode());
        assertNotNull(balance.getLinks());
        assertNotNull(balance.getLinks().getSelf());
    }
}
