package com.microsoft.univstore.partnercentersdk.core.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponent;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.utils.KeyValuePair;
import com.microsoft.univstore.partnercentersdk.models.utils.Tuple;

// -----------------------------------------------------------------------
// <copyright file="OrderSubscriptionCollectionOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Implements getting customer subscriptions for a given order.
 */
public class OrderSubscriptionCollectionOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements IEntireEntityCollectionRetrievalOperations<Subscription, ResourceCollection<Subscription>>
{
    /**
     * Initializes a new instance of the {@link #OrderSubscriptionCollectionOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     * @param orderId The order Id.
     */
    public OrderSubscriptionCollectionOperations( IPartnerOperations rootPartnerOperations, String customerId,
                                                  String orderId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( customerId, orderId ) );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

        if ( StringHelper.isNullOrWhiteSpace( orderId ) )
        {
            throw new IllegalArgumentException( "orderId must be set." );
        }

    }

    /**
     * Gets the subscriptions for the given order.
     * 
     * @return The order subscriptions.
     */
    @Override
    public ResourceCollection<Subscription> get()
    {

        PartnerServiceProxy<Subscription, ResourceCollection<Subscription>> partnerServiceProxy =
            new PartnerServiceProxy<Subscription, ResourceCollection<Subscription>>( new TypeReference<ResourceCollection<Subscription>>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptionsByOrder" ).getPath(),
                                                        this.getContext().getItem1(), Locale.US ) );

        partnerServiceProxy.getUriParameters().add( new KeyValuePair<String, String>( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerSubscriptionsByOrder" ).getParameters().get( "OrderId" ),
                                                                                      this.getContext().getItem2() ) );
        return partnerServiceProxy.get();

    }

}
