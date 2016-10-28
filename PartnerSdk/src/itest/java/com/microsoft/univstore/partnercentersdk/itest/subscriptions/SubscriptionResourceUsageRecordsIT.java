package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.exception.PartnerException;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.AzureResourceMonthlyUsageRecord;

public class SubscriptionResourceUsageRecordsIT
{
    @Test
    public void test()
    {
        fail("This test is taking one hour to run, since it can't find any subscription with usage records.");
        
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        ResourceCollection<Customer> customerCollection = partnerOperations.getCustomers().get();

        ResourceCollection<Subscription> subscriptionCollection = null;
        ResourceCollection<AzureResourceMonthlyUsageRecord> usageTry = null;
        ResourceCollection<AzureResourceMonthlyUsageRecord> usage = null;
        for ( Customer customer : customerCollection.getItems() )
        {
            if ( !customer.getId().equals( "edec6ec9-35be-4de7-9d19-f53270a7a1be" ) )
                ;
            {
                try
                {
                    subscriptionCollection =
                        partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();

                    for ( Subscription subscription : subscriptionCollection.getItems() )
                    {
                        if ( subscription.getOfferId().startsWith( "MS-AZR" ) )
                        {
                            usageTry =
                                partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().byId( subscription.getId() ).getResourceUsageRecords().get();

                            if ( usageTry.getTotalCount() > 0 )
                            {
                                usage = usageTry;
                                break;
                            }
                        }
                    }
                }
                catch ( PartnerException e )
                {
                    System.out.println( "error" );
                }
            }
            if (usage != null)
            {
                break;
            }
        }

        assertNotNull( "No subscription resource usage records were found", usage );
        assertTrue( usage.getTotalCount() > 0 );
        assertNotNull( usage.getItems().iterator().next() );
    }
}
