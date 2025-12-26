package com.web.monitor.common.dao.repository;

import com.web.monitor.common.dao.entity.UserFeedbackEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class UserFeedbackRepository extends DynamoDbRepository<UserFeedbackEntity> {

    public UserFeedbackRepository(DynamoDbTable<UserFeedbackEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }
}
