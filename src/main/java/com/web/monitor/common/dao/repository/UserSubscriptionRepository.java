package com.web.monitor.common.dao.repository;

import com.web.monitor.common.dao.entity.UserSubscriptionEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class UserSubscriptionRepository extends DynamoDbRepository<UserSubscriptionEntity> {

    public UserSubscriptionRepository(DynamoDbTable<UserSubscriptionEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }

    public UserSubscriptionEntity findByUserId(String userId) {
        return queryByPartitionKey(userId).stream()
                .findFirst()
                .orElse(null);
    }
}
