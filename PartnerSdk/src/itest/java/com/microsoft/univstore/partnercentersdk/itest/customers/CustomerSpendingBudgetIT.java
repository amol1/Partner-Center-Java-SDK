package com.microsoft.univstore.partnercentersdk.itest.customers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.itest.CredentialsHelper;
import com.microsoft.univstore.partnercentersdk.models.PagedResourceCollection;
import com.microsoft.univstore.partnercentersdk.models.customers.Customer;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SpendingBudget;

public class SpendingBudgetIT
{

    @Test
    public void test()
    {
        IPartnerOperations partnerOperations = new CredentialsHelper().getPartnerOperations();

        PagedResourceCollection<Customer> customerCollection = partnerOperations.getCustomers().get();
        SpendingBudget spendingBudget = null;        
        
        for (Customer customer : customerCollection.getItems())
        {
            SpendingBudget spendingBudgetTry = partnerOperations.getCustomers().byId( customer.getId() ).getUsageBudget().get();
            if (spendingBudgetTry.getUsageSpendingBudget() != null)
            {
                spendingBudget = spendingBudgetTry;
                break;
            }
        }
        
        assertNotNull(spendingBudget);
        assertNotNull(spendingBudget.getAttributes());
        assertNotNull(spendingBudget.getAttributes().getObjectType());
        assertNotNull(spendingBudget.getUsageSpendingBudget());
    }
}
