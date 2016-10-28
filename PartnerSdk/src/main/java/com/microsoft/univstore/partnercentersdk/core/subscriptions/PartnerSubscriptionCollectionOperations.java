package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="PartnerSubscriptionCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements customer subscription operations grouped by a Microsoft partner.
 */
public class PartnerSubscriptionCollectionOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements IEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>>
{
    /**
     * Initializes a new instance of the {@link #PartnerSubscriptionCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     * @param partnerId The partner Id.
     */
    public PartnerSubscriptionCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId,
                                                    String partnerId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( customerId, partnerId ) );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

        if ( StringHelper.isNullOrWhiteSpace( partnerId ) )
        {
            throw new IllegalArgumentException( "partnerId must be set." );
        }

    }

    /**
     * Gets the subscriptions for the given partner.
     * 
     * @return The partner subscriptions.
     */
    @Override
    public ResourceCollection<Subscription> get()
    {
        return this.get( 0, Integer.MAX_VALUE );
    }

    /**
     * Gets a segment of the subscriptions for the given partner.
     * 
     * @param offset The starting index.
     * @param size The desired segment size.
     * @return The required subscriptions segment.
     */
    @Override
    public ResourceCollection<Subscription> get( int offset, int size )
    {
        PartnerServiceProxy<Subscription, ResourceCollection<Subscription>> partnerServiceProxy =
            new PartnerServiceProxy<Subscription, ResourceCollection<Subscription>>( new TypeReference<ResourceCollection<Subscription>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptionsByPartner" ).getPath(),
                                                        this.getContext().getItem1(), Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptionsByPartner" ).getParameters().get( "PartnerId" ),
                                                                                      this.getContext().getItem2() ) );
        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptionsByPartner" ).getParameters().get( "Offset" ),
                                                                                      String.valueOf( offset ) ) );
        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptionsByPartner" ).getParameters().get( "Size" ),
                                                                                      String.valueOf( size ) ) );
        return partnerServiceProxy.get();
    }

}
