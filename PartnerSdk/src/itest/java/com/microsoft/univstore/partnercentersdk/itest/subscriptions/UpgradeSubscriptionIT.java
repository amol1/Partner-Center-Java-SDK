package com.microsoft.univstore.partnercentersdk.itest.subscriptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.ResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Subscription;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.Upgrade;
import com.microsoft.univstore.partnercentersdk.models.subscriptions.UpgradeResult;

public class UpgradeSubscriptionIT
{
    @Test
    public void test()
    {
        fail( "After going through all subscriptions from all customers, no eligible upgrade was found" );

        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        ResourceCollection<Customer> customerCollection = partnerOperations.getCustomers().get();

        Customer customerWithUpgrade = null;
        Subscription subscriptionForUpgrade = null;
        Upgrade targetOffer = null;
        
        for ( Customer customer : customerCollection.getItems() )
        {
            ResourceCollection<Subscription> customerSubscriptions =
                partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().get();

            for ( Subscription subscription : customerSubscriptions.getItems() )
            {
                ResourceCollection<Upgrade> subscriptionUpgradeCollection =
                    partnerOperations.getCustomers().byId( customer.getId() ).getSubscriptions().byId( subscription.getId() ).getUpgrades().get();

                for ( Upgrade upgrade : subscriptionUpgradeCollection.getItems() )
                {
                    if ( upgrade.isEligible() )
                    {
                        customerWithUpgrade = customer;
                        targetOffer = upgrade;
                        subscriptionForUpgrade = subscription;
                        break;
                    }
                }
                if ( targetOffer != null )
                {
                    break;
                }
            }
            if ( targetOffer != null )
            {
                break;
            }
        }

        assertNotNull( targetOffer );

        UpgradeResult upgradeResult =
            partnerOperations.getCustomers().byId( customerWithUpgrade.getId() ).getSubscriptions().byId( subscriptionForUpgrade.getId() ).getUpgrades().create( targetOffer );

        assertNull( upgradeResult.getLicenseErrors() );
        assertNull( upgradeResult.getUpgradeErrors() );
        assertNotNull( upgradeResult.getAttributes() );
        assertNotNull( upgradeResult.getAttributes().getEtag() );
        assertNotNull( upgradeResult.getAttributes().getObjectType() );
        assertNotNull( upgradeResult.getSourceSubscriptionId() );
        assertNotNull( upgradeResult.getTargetSubscriptionId() );
        assertNotNull( upgradeResult.getUpgradeType() );

    }
}
