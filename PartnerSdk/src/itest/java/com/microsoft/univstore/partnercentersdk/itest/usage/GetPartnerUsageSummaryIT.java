package com.microsoft.univstore.partnercentersdk.itest.usage;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.PartnerUsageSummary;

public class GetPartnerUsageSummaryIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PartnerUsageSummary usageSummary = partnerOperations.getUsageSummary().get();
        
        assertNotNull(usageSummary);
        assertNotNull(usageSummary.getAttributes());
        //assertNotNull(usageSummary.getAttributes().getEtag());
        assertNotNull(usageSummary.getAttributes().getObjectType());
        assertNotNull(usageSummary.getBillingEndDate());
        assertNotNull(usageSummary.getBillingStartDate());
        assertNotNull(usageSummary.getCurrencyLocale());
        //assertNotNull(usageSummary.getEmailNotification());
        assertNotNull(usageSummary.getId());
        assertNotNull(usageSummary.getLinks());
        assertNotNull(usageSummary.getLinks().getSelf());
        assertNotNull(usageSummary.getName());
    }
}
