package com.microsoft.univstore.partnercentersdk.models.query;

import com.microsoft.univstore.partnercentersdk.models.query.filters.FieldFilter;
import com.microsoft.univstore.partnercentersdk.models.query.sort.Sort;

// -----------------------------------------------------------------------
// <copyright file="QueryFactory.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Creates new instances of {@link #IQuery} objects.
 */
public class QueryFactory
{
    /**
     * Builds a simple query.
     * 
     * @param filter An optional filter.
     * @param sortOption Optional sorting options.
     * @param token Optional query token.
     * @return A simple query.
     */
    public static IQuery buildSimpleQuery( FieldFilter filter, Sort sortOption, Object token )

    {
        IQuery query = new SimpleQuery();
        query.setFilter( filter );
        query.setSort( sortOption );
        query.setToken( token );
        return query;
    }

    public static IQuery buildSimpleQuery( FieldFilter filter, Sort sortOption )

    {
        return buildSimpleQuery( filter, sortOption, null );
    }

    public static IQuery buildSimpleQuery( FieldFilter filter )

    {
        return buildSimpleQuery( filter, null, null );
    }

    public static IQuery buildSimpleQuery()

    {
        return buildSimpleQuery( null, null, null );
    }

    /**
     * Builds an indexed query.
     * 
     * @param pageSize The number of results to return.
     * @param index The results starting index.
     * @param filter An optional filter.
     * @param sortOption Optional sorting options.
     * @param token Optional query token.
     * @return A paged query.
     */
    public static IQuery buildIndexedQuery( int pageSize, int index, FieldFilter filter, Sort sortOption, Object token )

    {
        IQuery query = new IndexedQuery();
        query.setPageSize( pageSize );
        query.setIndex( index );
        query.setFilter( filter );
        query.setSort( sortOption );
        query.setToken( token );
        return query;
    }

    public static IQuery buildIndexedQuery( int pageSize, int index, FieldFilter filter, Sort sortOption )

    {
        return buildIndexedQuery( pageSize, index, filter, sortOption, null );
    }

    public static IQuery buildIndexedQuery( int pageSize, int index, FieldFilter filter )

    {
        return buildIndexedQuery( pageSize, index, filter, null, null );
    }

    public static IQuery buildIndexedQuery( int pageSize, int index )

    {
        return buildIndexedQuery( pageSize, index, null, null, null );
    }

    public static IQuery buildIndexedQuery( int pageSize )

    {
        return buildIndexedQuery( pageSize, 0, null, null, null );
    }

    /**
     * Builds a count query.
     * 
     * @param filter An optional filter.
     * @param token Optional query token.
     * @return A count query.
     */
    public static IQuery buildCountQuery( FieldFilter filter, Object token )

    {
        IQuery query = new CountQuery();
        query.setFilter( filter );
        query.setToken( token );
        return query;
    }

    public static IQuery buildCountQuery( FieldFilter filter )

    {
        return buildCountQuery( filter, null );
    }

    public static IQuery buildCountQuery()

    {
        return buildCountQuery( null, null );
    }

    /**
     * Builds a seek query.
     * 
     * @param seekOperation The seek operation to perform.
     * @param pageSize The desired result page size.
     * @param index The index of the page to retrieve. This is only used if the seek operation specified a page index.
     * @param filter An optional filter to apply.
     * @param sortingOption An optional sorting options.
     * @param token An optional query token.
     * @return The seek query.
     */
    public static IQuery buildSeekQuery( SeekOperation seekOperation, int pageSize, int index, FieldFilter filter,
                                         Sort sortingOption, Object token )

    {
        IQuery query = new SeekQuery();
        query.setSeekOperation( seekOperation );
        query.setPageSize( pageSize );
        query.setIndex( index );
        query.setFilter( filter );
        query.setSort( sortingOption );
        query.setToken( token );
        return query;
    }

    public static IQuery buildSeekQuery( SeekOperation seekOperation, int pageSize, int index, FieldFilter filter,
                                         Sort sortingOption )

    {
        return buildSeekQuery( seekOperation, pageSize, index, filter, sortingOption, null );
    }

    public static IQuery buildSeekQuery( SeekOperation seekOperation, int pageSize, int index, FieldFilter filter )

    {
        return buildSeekQuery( seekOperation, pageSize, index, filter, null, null );
    }

    public static IQuery buildSeekQuery( SeekOperation seekOperation, int pageSize, int index )

    {
        return buildSeekQuery( seekOperation, pageSize, index, null, null, null );
    }

    public static IQuery buildSeekQuery( SeekOperation seekOperation, int pageSize )

    {
        return buildSeekQuery( seekOperation, pageSize, 0, null, null, null );
    }

    public static IQuery buildSeekQuery( SeekOperation seekOperation )

    {
        return buildSeekQuery( seekOperation, 0, 0, null, null, null );
    }
}
