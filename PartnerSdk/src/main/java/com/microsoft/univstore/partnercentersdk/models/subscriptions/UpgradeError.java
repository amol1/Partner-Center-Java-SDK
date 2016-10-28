package com.microsoft.univstore.partnercentersdk.models.subscriptions;

import com.microsoft.univstore.partnercentersdk.models.ResourceBase;

// -----------------------------------------------------------------------
// <copyright file="UpgradeError.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Represents an error for subscription upgrade eligibility
 */
public class UpgradeError
    extends ResourceBase
{
    /**
     * Gets or sets the error code associated with the issue.
     */
    private UpgradeErrorCode __Code;

    public UpgradeErrorCode getCode()
    {
        return __Code;
    }

    public void setCode( UpgradeErrorCode value )
    {
        __Code = value;
    }

    /**
     * Gets or sets the friendly text describing the error.
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
     * Gets or sets additional details regarding the error.
     */
    private String __AdditionalDetails;

    public String getAdditionalDetails()
    {
        return __AdditionalDetails;
    }

    public void setAdditionalDetails( String value )
    {
        __AdditionalDetails = value;
    }

}
