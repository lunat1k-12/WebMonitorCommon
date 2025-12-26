package com.web.monitor.common.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@DynamoDbBean
public class UserSubscriptionEntity {

    private String userId;
    private String subscriptionType;
    private String stripeCustomerId;
    private String stripeSubscriptionId;
    private String stripeProductId;
    private String stripePriceId;
    private String status; // active, inactive, past_due, canceled, etc.
    private Instant createdAt;
    private Instant updatedAt;
    private Instant currentPeriodStart;
    private Instant currentPeriodEnd;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    @DynamoDbAttribute("stripeCustomerId")
    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    @DynamoDbAttribute("stripeSubscriptionId")
    public String getStripeSubscriptionId() {
        return stripeSubscriptionId;
    }

    @DynamoDbAttribute("stripeProductId")
    public String getStripeProductId() {
        return stripeProductId;
    }

    @DynamoDbAttribute("stripePriceId")
    public String getStripePriceId() {
        return stripePriceId;
    }

    @DynamoDbAttribute("status")
    public String getStatus() {
        return status;
    }

    @DynamoDbAttribute("createdAt")
    public Instant getCreatedAt() {
        return createdAt;
    }

    @DynamoDbAttribute("updatedAt")
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @DynamoDbAttribute("currentPeriodStart")
    public Instant getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    @DynamoDbAttribute("currentPeriodEnd")
    public Instant getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    @DynamoDbAttribute("subscriptionType")
    public String getSubscriptionType() {
        return subscriptionType;
    }
}
