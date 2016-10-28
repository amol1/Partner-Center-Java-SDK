// -----------------------------------------------------------------------
// <copyright file="CustomerUsageSpendingBudgetOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.univstore.partnercentersdk.core.customers;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.utils.StringHelper;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.SpendingBudget;

/**
 * This class implements the operations available on a customer's usage spending budget.
 */
public class CustomerUsageSpendingBudgetOperations
    extends BasePartnerComponentString
    implements ICustomerUsageSpendingBudgetOperations
{
    /**
     * Initializes a new instance of the {@link #CustomerUsageSpendingBudgetOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer Id.
     */
    public CustomerUsageSpendingBudgetOperations( IPartnerOperations rootPartnerOperations, String customerId )
    {
        super( rootPartnerOperations, customerId );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId must be set." );
        }

    }

    /**
     * Gets the usage spending budget allocated to a customer by the partner.
     * 
     * @return The customer usage spending budget.
     */
    @Override
    public SpendingBudget get()
    {
        IPartnerServiceProxy<SpendingBudget, SpendingBudget> partnerServiceProxy =
            new PartnerServiceProxy<SpendingBudget, SpendingBudget>( new TypeReference<SpendingBudget>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetCustomerUsageSpendingBudget" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.get();
    }

    /**
     * Updates the usage spending budget allocated to a customer by the partner.
     * 
     * @param usageSpendingBudget The new customer usage spending budget.
     * @return The updated customer usage spending budget.
     */
    @Override
    public SpendingBudget update( SpendingBudget usageSpendingBudget )
    {
        if ( usageSpendingBudget == null )
        {
            throw new IllegalArgumentException( "usage spending budget is required." );
        }
        IPartnerServiceProxy<SpendingBudget, SpendingBudget> partnerServiceProxy =
            new PartnerServiceProxy<SpendingBudget, SpendingBudget>( new TypeReference<SpendingBudget>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "PatchCustomerUsageSpendingBudget" ).getPath(),
                                                        this.getContext(), Locale.US ) );
        return partnerServiceProxy.patch( usageSpendingBudget );
    }

}
