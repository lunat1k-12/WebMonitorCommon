package com.web.monitor.common.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@DynamoDbBean
public class NotificationTargetEntity {

    private String scheduleId;
    private String id;
    private String type;
    private String emailRecipient;
    private String phoneNumber;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("scheduleId")
    public String getScheduleId() {
        return scheduleId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("type")
    public String getType() {
        return type;
    }

    @DynamoDbAttribute("emailRecipient")
    public String getEmailRecipient() {
        return emailRecipient;
    }

    @DynamoDbAttribute("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
