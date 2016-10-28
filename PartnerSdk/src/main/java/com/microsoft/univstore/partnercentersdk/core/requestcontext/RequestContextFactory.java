package com.microsoft.univstore.partnercentersdk.core.requestcontext;

import java.util.UUID;

//-----------------------------------------------------------------------
//<copyright file="RequestContextFactory.cs" company="Microsoft">
//   Copyright (c) Microsoft Corporation.  All rights reserved.
//</copyright>
//-----------------------------------------------------------------------
/**
 * Creates instances of {@link #IRequestContext} .
 */
public class RequestContextFactory
{
    /**
     * Creates a request context object which will use a randomly generated correlation Id and a unique request Id for
     * each partner API call.
     * 
     * @return A request context object.
     */
    public static IRequestContext create()
    {
        return new RequestContext();
    }

    /**
     * Creates a request context object which will use a randomly generated correlation Id, a unique request Id and
     * provided locale for each partner API call.
     * 
     * @param locale The locale.
     * @return A request context object.
     */
    public static IRequestContext create( String locale )
    {
        return new RequestContext( locale );
    }

    /**
     * Creates a request context object with the provided correlation Id and a unique request Id for each partner API
     * call.
     * 
     * @param correlationId The correlation Id.
     * @return A request context object.
     */
    public static IRequestContext create( UUID correlationId )
    {
        return new RequestContext( correlationId );
    }

    /**
     * Creates a request context object with the provided correlation Id, a unique request Id and provided locale for
     * each partner API call.
     * 
     * @param correlationId The correlation Id.
     * @param locale The locale
     * @return A request context object.
     */
    public static IRequestContext create( UUID correlationId, String locale )
    {
        return new RequestContext( correlationId, locale );
    }

    /**
     * Creates a request context object with the provided correlation and request Ids.
     * 
     * @param correlationId The correlation Id.
     * @param requestId The request Id.
     * @return A request context object.
     */
    public static IRequestContext create( UUID correlationId, UUID requestId )
    {
        return new RequestContext( correlationId, requestId, null );
    }

    /**
     * Creates a request context object with the provided correlation, request Ids and locale.
     * 
     * @param correlationId The correlation Id.
     * @param requestId The request Id.
     * @param locale The locale.
     * @return A request context object.
     */
    public static IRequestContext create( UUID correlationId, UUID requestId, String locale )
    {
        return new RequestContext( correlationId, requestId, locale );
    }

}
