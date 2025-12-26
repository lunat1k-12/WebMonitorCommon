package com.web.monitor.common.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@DynamoDbBean
public class UserPaymentEntity {

    private String userId;
    private String stripeId;
    private String invoiceUrl;
    private String invoicePdfUrl;
    private Long timestampUtc;
    private Long totalPaid;

    @DynamoDbAttribute("totalPaid")
    public Long getTotalPaid() {
        return totalPaid;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("stripeId")
    public String getStripeId() {
        return stripeId;
    }

    @DynamoDbAttribute("invoiceUrl")
    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    @DynamoDbAttribute("invoicePdfUrl")
    public String getInvoicePdfUrl() {
        return invoicePdfUrl;
    }

    @DynamoDbSecondarySortKey(indexNames = {"paginatedIndex"})
    @DynamoDbAttribute("timestampUtc")
    public Long getTimestampUtc() {
        return timestampUtc;
    }
}
