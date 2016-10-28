package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;

public class GetSubscriptionIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery(partnerOperations);

        Subscription subscription = SubscriptionHelper.getFirstSubscriptionFromPagedQuery( partnerOperations, customer );
        
        subscription = partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().byId( subscription.getId() ).get();

        assertNotNull( subscription );  
        assertNotNull( subscription.getAttributes() ); 
        assertNotNull( subscription.getAttributes().getEtag() );
        assertNotNull( subscription.getAttributes().getObjectType() );
        assertNotNull( subscription.getAutoRenewEnabled() );
        assertNotNull( subscription.getBillingType() );
        assertNotNull( subscription.getCommitmentEndDate() );
        assertNotNull( subscription.getContractType() );
        assertNotNull( subscription.getCreationDate() );
        assertNotNull( subscription.getEffectiveStartDate() );
        assertNotNull( subscription.getFriendlyName() );
        assertNotNull( subscription.getId() );
        assertNotNull( subscription.getLinks() ); 
        assertNotNull( subscription.getLinks().getSelf() );
        assertNotNull( subscription.getOfferId() );
        assertNotNull( subscription.getOrderId() );
        //assertNotNull( subscription.getParentSubscriptionId() );
        //assertNotNull( subscription.getPartnerId() );
        assertTrue(subscription.getQuantity() > 0);
        //assertNotNull(subscription.getSuspensionReasons());
        assertNotNull( subscription.getUnitType() );
    }
}
