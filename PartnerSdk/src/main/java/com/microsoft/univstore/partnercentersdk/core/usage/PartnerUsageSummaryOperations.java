package com.microsoft.univstore.partnercentersdk.core.usage;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.univstore.partnercentersdk.core.BasePartnerComponentString;
import com.microsoft.univstore.partnercentersdk.core.IPartnerOperations;
import com.microsoft.univstore.partnercentersdk.core.MicrosoftPartnerSdk;
import com.microsoft.univstore.partnercentersdk.core.network.IPartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.core.network.PartnerServiceProxy;
import com.microsoft.univstore.partnercentersdk.models.usagemanagement.PartnerUsageSummary;

// -----------------------------------------------------------------------
// <copyright file="PartnerUsageSummaryOperations.cs" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------
/**
 * This class implements the operations available on a partner's usage summary.
 */
public class PartnerUsageSummaryOperations
    extends BasePartnerComponentString
    implements IPartnerUsageSummaryOperations
{
    /**
     * Initializes a new instance of the {@link #PartnerUsageSummaryOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     */
    public PartnerUsageSummaryOperations( IPartnerOperations rootPartnerOperations )
    {
        super( rootPartnerOperations );
    }

    /**
     * Gets the partner's usage summary.
     * 
     * @return The partner's usage summary.
     */
    @Override
    public PartnerUsageSummary get()
    {
        IPartnerServiceProxy<PartnerUsageSummary, PartnerUsageSummary> partnerServiceProxy =
            new PartnerServiceProxy<PartnerUsageSummary, PartnerUsageSummary>( new TypeReference<PartnerUsageSummary>()
            {
            }, this.getPartner(), MessageFormat.format( MicrosoftPartnerSdk.getConfiguration().getApis().get( "GetPartnerUsageSummary" ).getPath(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

}
