package com.microsoft.univstore.partnercentersdk.core.profiles;

import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;

// -----------------------------------------------------------------------
// <copyright file="PartnerProfileCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * The partner profile collection operations implementation.
 */
public class PartnerProfileCollectionOperations
    extends BasePartnerComponentString
    implements IPartnerProfileCollectionOperations
{
    /**
     * The legal business profile operations.
     */
    private ILegalBusinessProfileOperations legalBusinessProfile;

    /**
     * The partner network profile operations.
     */
    private IPartnerNetworkProfileOperations partnerNetworkProfileOperations;

    /**
     * The partner support profile operations.
     */
    private ISupportProfileOperations supportProfileOperations;

    /**
     * The organization profile operations.
     */
    private IOrganizationProfileOperations organizationProfile;

    /**
     * The partner billing profile operations.
     */
    private IPartnerBillingProfileOperations partnerBillingProfile;

    /**
     * The partner profile types operations.
     */
    private IPartnerProfileTypeCollectionOperations partnerProfileTypesCollectionOperations;

    /**
     * Initializes a new instance of the {@link #PartnerProfileCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public PartnerProfileCollectionOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Gets the operations available for the legal business profile.
     */
    @Override
    public ILegalBusinessProfileOperations getLegalBusinessProfile()
    {
        if ( this.legalBusinessProfile == null )
        {
            this.legalBusinessProfile = new LegalBusinessProfileOperations( this.getPartner() );
        }
        return this.legalBusinessProfile;
    }

    /**
     * Gets the operations available for the partner network profile.
     */
    @Override
    public IPartnerNetworkProfileOperations getPartnerNetworkProfile()
    {
        if ( this.partnerNetworkProfileOperations == null )
        {
            this.partnerNetworkProfileOperations = new PartnerNetworkProfileOperations( this.getPartner() );
        }
        return this.partnerNetworkProfileOperations;
    }

    /**
     * Gets the operations available for the partner network profile.
     */
    @Override
    public ISupportProfileOperations getSupportProfile()
    {
        if ( this.supportProfileOperations == null )
        {
            this.supportProfileOperations = new SupportProfileOperations( this.getPartner() );
        }
        return this.supportProfileOperations;
    }

    /**
     * Gets the operations available for the organization profile.
     */
    @Override
    public IOrganizationProfileOperations getOrganizationProfile()
    {
        if ( this.organizationProfile == null )
        {
            this.organizationProfile = new OrganizationProfileOperations( this.getPartner() );
        }
        return this.organizationProfile;
    }

    /**
     * Gets the operations available for the partner billing profile.
     */
    @Override
    public IPartnerBillingProfileOperations getPartnerBillingProfile()
    {
        if ( this.partnerBillingProfile == null )
        {
            this.partnerBillingProfile = new PartnerBillingProfileOperations( this.getPartner() );
        }
        return this.partnerBillingProfile;
    }

    /**
     * Gets the operations available for the partner profile types.
     */
    @Override
    public IPartnerProfileTypeCollectionOperations getTypes()
    {
        if ( this.partnerProfileTypesCollectionOperations == null )
        {
            this.partnerProfileTypesCollectionOperations =
                new PartnerProfileTypeCollectionOperations( this.getPartner() );
        }
        return this.partnerProfileTypesCollectionOperations;
    }

}
