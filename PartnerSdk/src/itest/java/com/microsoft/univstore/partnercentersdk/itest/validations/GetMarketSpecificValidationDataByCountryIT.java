package com.microsoft.univstore.partnercentersdk.itest.validations;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.validations.CountryInformation;

public class GetMarketSpecificValidationDataByCountryIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();
        
        CountryInformation countryInformation = partnerOperations.getValidations().getMarketSpecificValidationDataByCountry("US");
        
        assertNotNull(countryInformation);
        assertNotNull(countryInformation.getAttributes());
        //assertNotNull(countryInformation.getAttributes().getEtag());
        assertNotNull(countryInformation.getAttributes().getObjectType());
        assertNotNull(countryInformation.getCountryCallingCodesList());
        assertNotNull(countryInformation.getDefaultCulture());
        //assertNotNull(countryInformation.getExtensionData());
        assertNotNull(countryInformation.getGeographicRegion());
        assertNotNull(countryInformation.getIsCityRequired());
        assertNotNull(countryInformation.getIso2Code());
        //assertNotNull(countryInformation.getIso3Code());
        assertNotNull(countryInformation.getIsPostalCodeRequired());
        assertNotNull(countryInformation.getIsRegistrationNumberSupported());
        assertNotNull(countryInformation.getIsStateRequired());
        assertNotNull(countryInformation.getIsTaxIdSupported());
        assertNotNull(countryInformation.getIsVatIdSupported());
        assertNotNull(countryInformation.getPhoneNumberRegex());
        assertNotNull(countryInformation.getPostalCodeRegex());
        assertNotNull(countryInformation.getResellerAgreementRegion());
        assertNotNull(countryInformation.getSupportedCulturesList());
        assertNotNull(countryInformation.getSupportedLanguagesList());
        assertNotNull(countryInformation.getSupportedStatesList());
        assertNotNull(countryInformation.getTaxIdFormat());
        assertNotNull(countryInformation.getTaxIdSample());
        //assertNotNull(countryInformation.getVatIdRegex());
    }

}
