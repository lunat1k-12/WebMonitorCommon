package com.web.monitor.common.dao.repository;

import com.web.monitor.common.dao.entity.ScreenshotMetadataEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class ScreenshotMetadataRepository extends DynamoDbRepository<ScreenshotMetadataEntity> {
    public ScreenshotMetadataRepository(DynamoDbTable<ScreenshotMetadataEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }
}
