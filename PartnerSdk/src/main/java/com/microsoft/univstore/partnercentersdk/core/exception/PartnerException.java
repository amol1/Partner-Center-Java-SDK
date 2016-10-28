package com.microsoft.univstore.partnercentersdk.core.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.microsoft.univstore.partnercentersdk.core.requestcontext.IRequestContext;
import com.microsoft.univstore.partnercentersdk.models.ApiFault;

// -----------------------------------------------------------------------
// <copyright file="PartnerException.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The standard exception thrown by the partner SDK. This pertains to errors accessing the partner service. Other
 * standard exceptions such as null argument exceptions will also be thrown in case of malformed input.
 */
public class PartnerException
    extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * Initializes a new instance of the {@link #PartnerException} class.
     */
    public PartnerException()
    {
        super();
        this.setErrorCategory( PartnerErrorCategory.NOT_SPECIFIED );
    }

    /**
     * Initializes a new instance of the {@link #PartnerException} class.
     * 
     * @param message The exception message.
     */
    public PartnerException( String message )
    {
        this( message, null );
    }

    /**
     * Initializes a new instance of the {@link #PartnerException} class.
     * 
     * @param message The exception message.
     * @param innerException The exception that is the cause of the current exception, or a null reference if no inner
     *            exception is specified.
     */
    public PartnerException( String message, Exception innerException )
    {
        super( message, innerException );
        this.setErrorCategory( PartnerErrorCategory.NOT_SPECIFIED );
    }

    /**
     * Initializes a new instance of the {@link #PartnerException} class.
     * 
     * @param message The exception message.
     * @param context The partner context.
     * @param errorCategory An optional error category.
     * @param innerException An optional inner exception.
     */
    // public PartnerException( String message, IRequestContext context )
    //
    // {
    // this( message, context, PartnerErrorCategory.NotSpecified, null );
    // }

    public PartnerException( String message, IRequestContext context, PartnerErrorCategory errorCategory )
    {
        this( message, context, errorCategory, null );
    }

    public PartnerException( String message, IRequestContext context, PartnerErrorCategory errorCategory,
                             Exception innerException )
    {
        super( message, innerException );
        this.setErrorCategory( errorCategory );
        this.setContext( context );
    }

    /**
     * Initializes a new instance of the {@link #PartnerException} class.
     * 
     * @param apiFault The API fault object returned by the partner service.
     * @param context The partner context.
     * @param errorCategory An optional error category.
     * @param innerException An optional inner exception.
     */
    public PartnerException( ApiFault apiFault, IRequestContext context )
    {
        this( apiFault, context, PartnerErrorCategory.NOT_SPECIFIED, null );
    }

    public PartnerException( ApiFault apiFault, IRequestContext context, PartnerErrorCategory errorCategory )
    {
        this( apiFault, context, errorCategory, null );
    }

    public PartnerException( ApiFault apiFault, IRequestContext context, PartnerErrorCategory errorCategory,
                             Exception innerException )
    {
        this( apiFault != null ? apiFault.getErrorMessage() : "", context, errorCategory, innerException );
        this.setServiceErrorPayload( apiFault );
    }

    /**
     * Gets the error classification that resulted in this exception.
     */
    private PartnerErrorCategory __ErrorCategory;

    public PartnerErrorCategory getErrorCategory()
    {
        return __ErrorCategory;
    }

    public void setErrorCategory( PartnerErrorCategory value )
    {
        __ErrorCategory = value;
    }

    /**
     * Gets the service error payload.
     */
    private ApiFault __ServiceErrorPayload;

    public ApiFault getServiceErrorPayload()
    {
        return __ServiceErrorPayload;
    }

    public void setServiceErrorPayload( ApiFault value )
    {
        __ServiceErrorPayload = value;
    }

    /**
     * Gets the partner context associated with the exception.
     */
    private IRequestContext __Context;

    public IRequestContext getContext()
    {
        return __Context;
    }

    public void setContext( IRequestContext value )
    {
        __Context = value;
    }

    /**
     * Displays the partner exception details.
     * 
     * @return A string representing the partner exception including the base and extended properties.
     */
    @Override
    public String toString()
    {
        return MessageFormat.format( "PartnerException: ErrorCategory: {0}, ServiceErrorPayload: {1}, Context: {2}, Base Description: {3}",
                                     this.getErrorCategory().toString(), this.getServiceErrorPayload() != null
                                                     ? this.getServiceErrorPayload().toString() : "null",
                                     this.getContext(), super.toString(), Locale.US );

    }

}
