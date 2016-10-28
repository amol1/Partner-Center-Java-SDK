package com.microsoft.univstore.partnercentersdk.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;

public class SdkConfigurationTest
{

    @Test
    public void CheckProperConfigurationSetup()
    {
        assertNotNull( MicrosoftPartnerSdk.getConfiguration() );
        assertNotNull( MicrosoftPartnerSdk.getConfiguration().getApis() );
        assertFalse( StringHelper.isNullOrEmpty( MicrosoftPartnerSdk.getPartnerServiceApiRoot() ) );
        assertFalse( StringHelper.isNullOrEmpty( MicrosoftPartnerSdk.getPartnerServiceApiVersion() ) );
    }

}
