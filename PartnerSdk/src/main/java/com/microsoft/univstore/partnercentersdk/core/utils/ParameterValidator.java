package com.microsoft.univstore.partnercentersdk.core.utils;

public class ParameterValidator
{
    public static void isIntInclusive( int min, int max, int parameterValue, String errorMessage )
    {
        if ( parameterValue < min || max < parameterValue )
        {
            throw new IllegalArgumentException( errorMessage );
        }
    }

    public static void isValidUriQueryValue( String string, String errorMessage )
    {
        if ( StringHelper.isEmptyOrContainsWhiteSpace( string ) )
        {
            throw new IllegalArgumentException( errorMessage );
        }
    }

}
