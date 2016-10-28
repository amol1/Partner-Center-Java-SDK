package com.microsoft.univstore.partnercentersdk.models.offers;

// -----------------------------------------------------------------------
// <copyright file="Product.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A product tied to an offer.
 */
public class Product
{
    /**
     * Gets or sets the identifier.
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
     * Gets or sets the name.
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
     * Gets or sets the unit.
     */
    private String __Unit;

    public String getUnit()
    {
        return __Unit;
    }

    public void setUnit( String value )
    {
        __Unit = value;
    }

}
