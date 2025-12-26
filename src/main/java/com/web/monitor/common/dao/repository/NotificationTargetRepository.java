package com.web.monitor.common.dao.repository;

import com.web.monitor.common.dao.entity.NotificationTargetEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class NotificationTargetRepository extends DynamoDbRepository<NotificationTargetEntity> {
    public NotificationTargetRepository(DynamoDbTable<NotificationTargetEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }
}
