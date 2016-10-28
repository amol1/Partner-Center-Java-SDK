package com.microsoft.univstore.partnercentersdk.models.partners;

import com.microsoft.univstore.partnercentersdk.models.Address;
import com.microsoft.univstore.partnercentersdk.models.SecureString;

// -----------------------------------------------------------------------
// <copyright file="PartnerUserProfile.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Partner User profile
 */
public class PartnerUserProfile
    extends UserProfile
{
    /**
     * Gets or sets the user identifier.
     */
    private String __UserId;

    public String getUserId()
    {
        return __UserId;
    }

    public void setUserId( String value )
    {
        __UserId = value;
    }

    /**
     * Gets or sets the name of the user principal.
     */
    private String __UserPrincipalName;

    public String getUserPrincipalName()
    {
        return __UserPrincipalName;
    }

    public void setUserPrincipalName( String value )
    {
        __UserPrincipalName = value;
    }

    /**
     * Gets or sets the email nickname.
     */
    private String __EmailNickname;

    public String getEmailNickname()
    {
        return __EmailNickname;
    }

    public void setEmailNickname( String value )
    {
        __EmailNickname = value;
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
     * Gets or sets the address.
     */
    private Address __Address;

    public Address getAddress()
    {
        return __Address;
    }

    public void setAddress( Address value )
    {
        __Address = value;
    }

    /**
     * Gets or sets the alternate emails.
     */
    private Iterable<String> __AlternateEmails;

    public Iterable<String> getAlternateEmails()
    {
        return __AlternateEmails;
    }

    public void setAlternateEmails( Iterable<String> value )
    {
        __AlternateEmails = value;
    }

    /**
     * Gets or sets the password.
     */
    private SecureString __Password;

    public SecureString getPassword()
    {
        return __Password;
    }

    public void setPassword( SecureString value )
    {
        __Password = value;
    }

    /**
     * Gets the name of the user.
     */
    public String getUserName()
    {
        if ( this.getUserPrincipalName() != null && this.getUserPrincipalName().indexOf( "@" ) >= 0 )
        {
            return this.getUserPrincipalName().substring( 0, this.getUserPrincipalName().indexOf( "@" ) );
        }

        return null;
    }

    /**
     * Gets the type of the profile.
     */
    public UserProfileType getProfileType()
    {
        return UserProfileType.USER_PROFILE;
    }

}
