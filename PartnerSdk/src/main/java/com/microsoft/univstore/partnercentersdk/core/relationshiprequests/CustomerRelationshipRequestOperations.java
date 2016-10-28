package com.microsoft.univstore.partnercentersdk.core.relationshiprequests;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.relationshiprequests.CustomerRelationshipRequest;

// -----------------------------------------------------------------------
// <copyright file="CustomerRelationshipRequestOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * Customer relationship request implementation class.
 */
public class CustomerRelationshipRequestOperations
    extends BasePartnerComponentString
    implements ICustomerRelationshipRequestOperations
{
    /**
     * Initializes a new instance of the {@link #CustomerRelationshipRequestOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public CustomerRelationshipRequestOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Retrieves the customer relationship request which can be used by a customer to establish a relationship with the
     * current partner.
     * 
     * @return A customer relationship request.
     */
    @Override
    public CustomerRelationshipRequest get()
    {
        IPartnerServiceProxy<CustomerRelationshipRequest, CustomerRelationshipRequest> partnerServiceProxy =
            new PartnerServiceProxy<CustomerRelationshipRequest, CustomerRelationshipRequest>( new TypeReference<CustomerRelationshipRequest>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerRelationshipRequest" ).getPath(),
                                                        Locale.US ) );
        return partnerServiceProxy.get();
    }

}
