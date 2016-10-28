package com.microsoft.univstore.partnercentersdk.core.utils;

import java.io.IOException;
import java.text.MessageFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.univstore.partnercentersdk.models.invoices.BillingProvider;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLicenseBasedBillingLineItem;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceLineItem;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceUsageBasedBillingLineItem;
import com.microsoft.univstore.partnercentersdk.models.invoices.InvoiceUsageBasedUsageLineItem;

public class InvoiceLineItemDeserializer
    extends JsonDeserializer<InvoiceLineItem>
{

    @Override
    public InvoiceLineItem deserialize( JsonParser parser, DeserializationContext context )
        throws IOException, JsonProcessingException
    {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode jsonNode = parser.readValueAsTree();
        Object target = null;
        String billingProvider = jsonNode.get( "billingProvider" ).textValue();
        String invoiceLineItemType = jsonNode.get( "invoiceLineItemType" ).textValue();
        if ( invoiceLineItemType.equals( "usage_line_items" ) )
        {
            if ( billingProvider.equalsIgnoreCase( BillingProvider.AZURE.getUrlName() ) )
            {
                target = mapper.readValue( parser, InvoiceUsageBasedUsageLineItem.class );
            }
        }
        else if ( invoiceLineItemType.equals( "billing_line_items" ) )
        {
            if ( billingProvider.equalsIgnoreCase( BillingProvider.AZURE.getUrlName() ) )
            {
                target = mapper.readValue( parser, InvoiceUsageBasedBillingLineItem.class );
            }
            else if ( billingProvider.equalsIgnoreCase( BillingProvider.OFFICE.getUrlName() ) )
            {
                target = mapper.readValue( parser, InvoiceLicenseBasedBillingLineItem.class );
            }
        }
        else
        {
            throw new IOException(MessageFormat.format( "InvoiceLineItemConverter cannot deserialize invoice line items with type {0}", invoiceLineItemType));
        }
        
        if (target == null)
        {
            throw new IOException(MessageFormat.format( "InvoiceLineItemConverter cannot deserialize invoice line items with type {0} and billing provider: {1}", invoiceLineItemType, billingProvider));
        }
        
        return (InvoiceLineItem) target;

    }

}
