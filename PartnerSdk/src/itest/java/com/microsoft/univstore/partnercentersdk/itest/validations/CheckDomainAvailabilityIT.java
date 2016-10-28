package com.microsoft.univstore.partnercentersdk.itest.validations;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;

public class CheckDomainAvailabilityIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();
        
        String domainPrefix = "abc123";
        Boolean result = partnerOperations.getValidations().checkDomainAvailability( domainPrefix );
        
        assertNotNull(result);
    }

}
