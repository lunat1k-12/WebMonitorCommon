package com.web.monitor.common.dao.repository;

import com.web.monitor.common.dao.entity.UserPaymentLinkEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class UserPaymentLinkRepository extends DynamoDbRepository<UserPaymentLinkEntity> {
    public UserPaymentLinkRepository(DynamoDbTable<UserPaymentLinkEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }
}
