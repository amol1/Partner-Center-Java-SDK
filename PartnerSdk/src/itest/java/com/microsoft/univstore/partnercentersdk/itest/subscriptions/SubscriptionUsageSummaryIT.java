package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.itest.customers.CustomerHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SubscriptionUsageSummary;

public class SubscriptionUsageSummaryIT
{
    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        Customer customer = CustomerHelper.getFirstCustomerFromPagedQuery( partnerOperations );

        ResourceCollection<Subscription> subscriptions =
            partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();
        SubscriptionUsageSummary usageTry = null;
        SubscriptionUsageSummary usage = null;

        for ( Subscription subscription : subscriptions.getItems() )
        {
            if ( subscription.getOfferId().startsWith( "MS-AZR" ) )
            {
                usageTry =
                    partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().byId( subscription.getId() ).getUsageSummary().get();

                usage = usageTry;
                break;
            }
        }
        assertNotNull( usage );
        assertNotNull( usage.getAttributes() );
        //assertNotNull( usage.getAttributes().getEtag() );
        assertNotNull( usage.getAttributes().getObjectType() );
        assertNotNull( usage.getBillingEndDate() );
        assertNotNull( usage.getBillingStartDate() );
        assertNotNull( usage.getCurrencyLocale() );
        assertNotNull( usage.getId() );
        assertNotNull( usage.getLinks() );
        assertNotNull( usage.getLinks().getSelf() );
        assertNotNull( usage.getName() );
    }
}
