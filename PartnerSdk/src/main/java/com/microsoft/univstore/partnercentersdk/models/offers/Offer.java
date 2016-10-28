package com.microsoft.univstore.partnercentersdk.models.offers;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.univstore.partnercentersdk.models.ResourceBase;
import com.microsoft.univstore.partnercentersdk.models.invoices.BillingType;

// -----------------------------------------------------------------------
// <copyright file="Offer.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents a form of product availability to customer
 */
@JsonIgnoreProperties( { "isInternal", "conversionTargetOffers", "partnerQualifications", "hasAddOns" } )
public class Offer
    extends ResourceBase
{
    /**
     * Initializes a new instance of the {@link #Offer} class.
     */
    public Offer()
    {
    }

    /**
     * Gets or sets the offer identifier.
     */
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
     * Gets or sets the offer name.
     */
    private String __Name;

    public String getName()
    {
        return __Name;
    }

    public void setName( String value )
    {
        __Name = value;
    }

    /**
     * Gets or sets the description.
     */
    private String __Description;

    public String getDescription()
    {
        return __Description;
    }

    public void setDescription( String value )
    {
        __Description = value;
    }

    /**
     * Gets or sets the minimum quantity available.
     */
    private int __MinimumQuantity;

    public int getMinimumQuantity()
    {
        return __MinimumQuantity;
    }

    public void setMinimumQuantity( int value )
    {
        __MinimumQuantity = value;
    }

    /**
     * Gets or sets the maximum quantity available.
     */
    private int __MaximumQuantity;

    public int getMaximumQuantity()
    {
        return __MaximumQuantity;
    }

    public void setMaximumQuantity( int value )
    {
        __MaximumQuantity = value;
    }

    /**
     * Gets or sets the category rank in collection This property should be set only in case of offer category
     * collections
     */
    private int __Rank;

    public int getRank()
    {
        return __Rank;
    }

    public void setRank( int value )
    {
        __Rank = value;
    }

    /**
     * Gets or sets the offer URI.
     */
    private URI __Uri;

    public URI getUri()
    {
        return __Uri;
    }

    public void setUri( URI value )
    {
        __Uri = value;
    }

    /**
     * Gets or sets the locale to which the offer applies.
     */
    private String __Locale;

    public String getLocale()
    {
        return __Locale;
    }

    public void setLocale( String value )
    {
        __Locale = value;
    }

    /**
     * Gets or sets the country where the offer applies
     */
    private String __Country;

    public String getCountry()
    {
        return __Country;
    }

    public void setCountry( String value )
    {
        __Country = value;
    }

    /**
     * Gets or sets the category.
     */
    private OfferCategory __Category;

    public OfferCategory getCategory()
    {
        return __Category;
    }

    public void setCategory( OfferCategory value )
    {
        __Category = value;
    }

    /**
     * Gets or sets the prerequisite offers.
     */
    private List<String> __PrerequisiteOffers;

    public List<String> getPrerequisiteOffers()
    {
        return __PrerequisiteOffers;
    }

    public void setPrerequisiteOffers( List<String> value )
    {
        __PrerequisiteOffers = value;
    }

    /**
     * Gets or sets a value indicating whether this instance is add-ons.
     */
    private Boolean __IsAddOn;

    public Boolean getIsAddOn()
    {
        return __IsAddOn;
    }

    public void setIsAddOn( Boolean value )
    {
        __IsAddOn = value;
    }

    /**
     * Gets or sets a value indicating whether this instance is available for purchase.
     */
    private Boolean __IsAvailableForPurchase;

    public Boolean getIsAvailableForPurchase()
    {
        return __IsAvailableForPurchase;
    }

    public void setIsAvailableForPurchase( Boolean value )
    {
        __IsAvailableForPurchase = value;
    }

    /**
     * Gets or sets how billing is done for the line item purchase.
     */
    private BillingType __Billing;

    public BillingType getBilling()
    {
        return __Billing;
    }

    public void setBilling( BillingType value )
    {
        __Billing = value;
    }

    /**
     * Gets or sets a value indicating whether [automatic renewable].
     */
    private Boolean __IsAutoRenewable;

    public Boolean getIsAutoRenewable()
    {
        return __IsAutoRenewable;
    }

    public void setIsAutoRenewable( Boolean value )
    {
        __IsAutoRenewable = value;
    }

    /**
     * Gets or sets the list of offers that this offer can be upgraded to.
     */
    private List<String> __UpgradeTargetOffers;

    public List<String> getUpgradeTargetOffers()
    {
        return __UpgradeTargetOffers;
    }

    public void setUpgradeTargetOffers( List<String> value )
    {
        __UpgradeTargetOffers = value;
    }

    /**
     * Gets or sets the product.
     */
    private Product __Product;

    public Product getProduct()
    {
        return __Product;
    }

    public void setProduct( Product value )
    {
        __Product = value;
    }

    /**
     * Gets or sets the type of the unit.
     */
    private String __UnitType;

    public String getUnitType()
    {
        return __UnitType;
    }

    public void setUnitType( String value )
    {
        __UnitType = value;
    }

    /**
     * Gets or sets the learn more link.
     */
    private OfferLinks __Links;

    public OfferLinks getLinks()
    {
        return __Links;
    }

    public void setLinks( OfferLinks value )
    {
        __Links = value;
    }

    /**
     * Gets or sets a value indicating the Sales Group Id.
     */
    private Boolean __SalesGroupId;

    public Boolean getSalesGroupId()
    {
        return __SalesGroupId;
    }

    public void setSalesGroupId( Boolean value )
    {
    	__SalesGroupId = value;
    }

}
