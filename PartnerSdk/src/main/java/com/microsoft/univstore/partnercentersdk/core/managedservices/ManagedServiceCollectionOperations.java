package com.microsoft.univstore.partnercentersdk.core.managedservices;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.ManagedService;

// -----------------------------------------------------------------------
// <copyright file="ManagedServiceCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements a customer's managed services operations.
 */
public class ManagedServiceCollectionOperations
    extends BasePartnerComponentString
    implements IManagedServiceCollectionOperations
{
    /**
     * Initializes a new instance of the {@link #ManagedServiceCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     */
    public ManagedServiceCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set" );
        }

    }

    /**
     * Gets managed services for a customer.
     * 
     * @return The customer's managed services.
     */
    @Override
    public ResourceCollection<ManagedService> get()
    {

        IPartnerServiceProxy<ManagedService, ResourceCollection<ManagedService>> partnerServiceProxy =
            new PartnerServiceProxy<ManagedService, ResourceCollection<ManagedService>>( new TypeReference<ResourceCollection<ManagedService>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerManagedServices" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }

}
