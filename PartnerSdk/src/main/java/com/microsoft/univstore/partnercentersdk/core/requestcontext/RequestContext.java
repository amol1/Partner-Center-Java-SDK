package com.microsoft.univstore.partnercentersdk.core.requestcontext;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.UUID;

import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;

// -----------------------------------------------------------------------
// <copyright file="RequestContext.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Request context implementation.
 */
public class RequestContext
    implements IRequestContext
{
    /**
     * Initializes a new instance of the {@link #RequestContext} class. Correlation Id will be generated. The request Id
     * will be automatically generated for each service API call.
     */
    public RequestContext()
    {
        this( UUID.randomUUID(), new UUID( 0, 0 ), null );
    }

    /**
     * Initializes a new instance of the {@link #RequestContext} class with provided locale. Correlation Id will be
     * generated. The request Id will be automatically generated for each service API call.
     * 
     * @param locale The locale.
     */
    public RequestContext( String locale )
    {
        this( UUID.randomUUID(), new UUID( 0, 0 ), locale );
    }

    /**
     * Initializes a new instance of the {@link #RequestContext} class with a correlation Id. The request Id will be
     * automatically generated and a default Locale is set for each service API call.
     * 
     * @param correlationId The correlation Id. This Id is used to group logical operations together.
     */
    public RequestContext( UUID correlationId )
    {
        this( correlationId, new UUID( 0, 0 ), null );
    }

    /**
     * Initializes a new instance of the {@link #RequestContext} class with a correlation Id and the provided locale.
     * The request Id will be automatically generated for each service API call.
     * 
     * @param correlationId The correlation Id. This Id is used to group logical operations together.
     * @param locale The locale.
     */
    public RequestContext( UUID correlationId, String locale )
    {
        this( correlationId, new UUID( 0, 0 ), locale );
    }

    /**
     * Initializes a new instance of the {@link #RequestContext} class with the given correlation, request Ids and
     * locale.
     * 
     * @param correlationId The correlation Id. This Id is used to group logical operations together.
     * @param requestId The request Id. Uniquely identifies the operation.
     * @param locale The locale.
     */
    public RequestContext( UUID correlationId, UUID requestId, String locale )
    {
        if ( StringHelper.isNullOrWhiteSpace( locale ) )
        {
            locale = MicrosoftPartnerSdk.getConfiguration().getDefaultLocale();
        }

        this.setCorrelationId( correlationId );
        this.setRequestId( requestId );
        this.setLocale( locale );
    }

    /**
     * Gets the request Id. Uniquely identifies the operation.
     */
    private UUID __RequestId;

    @Override
    public UUID getRequestId()
    {
        return __RequestId;
    }

    public void setRequestId( UUID value )
    {
        __RequestId = value;
    }

    /**
     * Gets the correlation Id. This Id is used to group logical operations together.
     */
    private UUID __CorrelationId;

    @Override
    public UUID getCorrelationId()
    {
        return __CorrelationId;
    }

    public void setCorrelationId( UUID value )
    {
        __CorrelationId = value;
    }

    /**
     * Gets the Locale.
     */
    private String __Locale = new String();

    @Override
    public String getLocale()
    {
        return __Locale;
    }

    public void setLocale( String value )
    {
        __Locale = value;
    }

    /**
     * Returns a string representation of the request context.
     * 
     * @return A string representation of the request context.
     */
    @Override
    public String toString()
    {
        return MessageFormat.format( "Request Id: {0}, Correlation Id: {1}, Locale: {2}"
            + this.getRequestId().toString(), this.getCorrelationId().toString(), this.getLocale(), Locale.US );
    }

}
