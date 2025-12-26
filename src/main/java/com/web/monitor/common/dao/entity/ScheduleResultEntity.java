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
public class ScheduleResultEntity {

    private String userId;
    private String id;
    private String prompt;
    private Boolean promptResult;
    private Boolean inProgress;
    private String scheduleId;
    private String s3Key;
    private Long timestampUtc;
    private String errorMsg;
    private String detailsMsg;

    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("prompt")
    public String getPrompt() {
        return prompt;
    }

    @DynamoDbAttribute("promptResult")
    public Boolean getPromptResult() {
        return promptResult;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("scheduleId")
    public String getScheduleId() {
        return scheduleId;
    }

    @DynamoDbAttribute("s3Key")
    public String getS3Key() {
        return s3Key;
    }

    @DynamoDbSecondarySortKey(indexNames = {"paginatedIndex"})
    @DynamoDbAttribute("timestampUtc")
    public Long getTimestampUtc() {
        return timestampUtc;
    }

    @DynamoDbAttribute("errorMsg")
    public String getErrorMsg() {
        return errorMsg;
    }

    @DynamoDbAttribute("detailsMsg")
    public String getDetailsMsg() {
        return detailsMsg;
    }

    @DynamoDbAttribute("inProgress")
    public Boolean getInProgress() {
        return inProgress;
    }
}
