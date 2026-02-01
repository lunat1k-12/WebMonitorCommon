package com.web.monitor.common.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@DynamoDbBean
public class UserScheduleRecordEntity {

    private String userId;
    private String id;
    private String scheduleType;
    private String targetLink;
    private String userPrompt;
    private String lastResulId;
    private String currentResultId;
    private String state;
    private String name;
    private String dailyTime;
    private String dayOftheWeek;
    private String schedulerId;
    private String timezone;
    private Integer windowHeight;
    private String selector;
    private String note;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = {"ScheduleTypeIndex"})
    @DynamoDbAttribute("scheduleType")
    public String getScheduleType() {
        return scheduleType;
    }

    @DynamoDbAttribute("targetLink")
    public String getTargetLink() {
        return targetLink;
    }

    @DynamoDbAttribute("userPrompt")
    public String getUserPrompt() {
        return userPrompt;
    }

    @DynamoDbAttribute("lastResultId")
    public String getLastResulId() {
        return lastResulId;
    }

    @DynamoDbAttribute("state")
    public String getState() {
        return state;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    @DynamoDbAttribute("dailyTime")
    public String getDailyTime() {
        return dailyTime;
    }

    @DynamoDbAttribute("dayOftheWeek")
    public String getDayOftheWeek() {
        return dayOftheWeek;
    }

    @DynamoDbAttribute("timezone")
    public String getTimezone() {
        return timezone;
    }

    @DynamoDbAttribute("schedulerId")
    public String getSchedulerId() {
        return schedulerId;
    }

    @DynamoDbAttribute("windowHeight")
    public Integer getWindowHeight() {
        return windowHeight;
    }

    @DynamoDbAttribute("currentResultId")
    public String getCurrentResultId() {
        return currentResultId;
    }

    @DynamoDbAttribute("selector")
    public String getSelector() {
        return selector;
    }

    @DynamoDbAttribute("note")
    public String getNote() {
        return note;
    }
}
