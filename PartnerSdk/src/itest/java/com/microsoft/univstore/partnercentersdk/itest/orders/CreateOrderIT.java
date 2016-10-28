package com.microsoft.univstore.partnercentersdk.itest.orders;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.requestcontext.RequestContextFactory;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.offers.Offer;
import com.microsoft.univstore.partnercentersdk.models.orders.Order;
import com.microsoft.univstore.partnercentersdk.models.orders.OrderLineItem;

public class CreateOrderIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations =
            new CredentialsHelper().getPartnerOperations().with( RequestContextFactory.create( "en-US" ) );

        ResourceCollection<Offer> offerResults = partnerOperations.getOffers().get( "US" );
        Offer offer = offerResults.getItems().iterator().next();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery( partnerOperations );
        
        OrderLineItem newOrderLineItem = new OrderLineItem();
        newOrderLineItem.setOfferId( offer.getId() );
        newOrderLineItem.setFriendlyName( "My offer purchase" );
        newOrderLineItem.setQuantity( 1 );
        
        List<OrderLineItem> newLineItems = new ArrayList<OrderLineItem>();
        newLineItems.add(newOrderLineItem);
        
        Order newOrder = new Order();   
        newOrder.setReferenceCustomerId( customer.getId() );
        newOrder.setLineItems( newLineItems );
        
        Order createdOrder = partnerOperations.getCustomers().byId( customer.getId() ).getOrders().create( newOrder );
       
        assertNotNull( createdOrder );  
        assertNotNull( createdOrder.getAttributes() );    
        assertNotNull( createdOrder.getAttributes().getEtag() );
        assertNotNull( createdOrder.getAttributes().getObjectType() );
        assertNotNull( createdOrder.getCreationDate() );
        assertNotNull( createdOrder.getId() );
        assertNotNull( createdOrder.getLineItems() );  
        assertNotNull( createdOrder.getLineItems().iterator().next() );
        assertNotNull( createdOrder.getReferenceCustomerId() );
        //assertNotNull( createdOrder.getStatus() );
    }
}
