package com.microsoft.univstore.partnercentersdk.models.query;

import com.microsoft.univstore.partnercentersdk.models.query.filters.FieldFilter;

// -----------------------------------------------------------------------
// <copyright file="CountQuery.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * A query that returns the number of entities that may optionally fit a filter.
 */
public class CountQuery
    extends BaseQuery
{
    protected CountQuery( Object token )

    {
        super( token );
    }

    protected CountQuery()

    {
        super();
    }

    /**
     * Gets the query type.
     */
    public QueryType getType()

    {
        return QueryType.COUNT;
    }

    /**
     * Gets or sets the query filter.
     */
    private FieldFilter __Filter;

    public FieldFilter getFilter()
    {
        return __Filter;
    }

    public void setFilter( FieldFilter value )
    {
        __Filter = value;
    }

    /**
     * Returns a string representation of the query.
     * 
     * @return A string representation of the query.
     */
    public String toString()
    {
        return ( this.getFilter() != null ) ? this.getFilter().toString() : super.toString();

    }

}
