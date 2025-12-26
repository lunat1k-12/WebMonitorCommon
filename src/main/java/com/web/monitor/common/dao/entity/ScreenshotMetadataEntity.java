package com.web.monitor.common.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@DynamoDbBean
public class ScreenshotMetadataEntity {

    private String s3Key;
    private String htmlSource;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("s3Key")
    public String getS3Key() {
        return s3Key;
    }

    @DynamoDbAttribute("htmlSource")
    public String getHtmlSource() {
        return htmlSource;
    }

    @Override
    public String toString() {
        return "ScreenshotMetadataEntity{" +
                "s3Key='" + s3Key + '\'' +
                '}';
    }
}
