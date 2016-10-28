package com.microsoft.univstore.partnercentersdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.univstore.partnercentersdk.models.ResourceBaseWithLinks;
import com.microsoft.univstore.partnercentersdk.models.UserCredentials;

// -----------------------------------------------------------------------
// <copyright file="Customer.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Base customer profile for both Company, Billing profiles
 */
public class Customer
    extends ResourceBaseWithLinks
{
    public Customer()

    {
    }

    /**
     * Gets or sets the identifier.
     */

    @JsonProperty( "id" )
    private String __Id;

    public String getId()
    {
        return __Id;
    }

    public void setId( String value )
    {
        __Id = value;
    }

    /**
     * Gets or sets the commerce identifier.
     */

    @JsonProperty( "commerceId" )
    private String __CommerceId;

    public String getCommerceId()
    {
        return __CommerceId;
    }

    public void setCommerceId( String value )
    {
        __CommerceId = value;
    }

    /**
     * Gets or sets the company profile.
     */
    @JsonProperty( "companyProfile" )
    private CustomerCompanyProfile __CompanyProfile;

    public CustomerCompanyProfile getCompanyProfile()
    {
        return __CompanyProfile;
    }

    public void setCompanyProfile( CustomerCompanyProfile value )
    {
        __CompanyProfile = value;
    }

    /**
     * Gets or sets the billing profile.
     */
    @JsonProperty( "billingProfile" )
    private CustomerBillingProfile __BillingProfile;

    public CustomerBillingProfile getBillingProfile()
    {
        return __BillingProfile;
    }

    public void setBillingProfile( CustomerBillingProfile value )
    {
        __BillingProfile = value;
    }

    /**
     * Gets or sets the relationship to partner.
     */
    @JsonProperty( "relationshipToPartner" )
    private CustomerPartnerRelationship __RelationshipToPartner;

    public CustomerPartnerRelationship getRelationshipToPartner()
    {
        return __RelationshipToPartner;
    }

    public void setRelationshipToPartner( CustomerPartnerRelationship value )
    {
        __RelationshipToPartner = value;
    }

    @JsonProperty( "allowDelegatedAccess" )
    private Boolean __AllowDelegatedAccess;

    /**
     * Gets or sets the allow delegated access.
     */
    public Boolean getAllowDelegatedAccess()
    {
        return __AllowDelegatedAccess;
    }

    public void setAllowDelegatedAccess( Boolean value )
    {
        __AllowDelegatedAccess = value;
    }

    /**
     * Gets or sets the user credentials.
     */
    @JsonProperty( "userCredentials" )
    private UserCredentials __UserCredentials;

    public UserCredentials getUserCredentials()
    {
        return __UserCredentials;
    }

    public void setUserCredentials( UserCredentials value )
    {
        __UserCredentials = value;
    }

}