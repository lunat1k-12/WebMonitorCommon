package com.web.monitor.common.dao.repository;

import com.web.monitor.common.dao.entity.UserScheduleRecordEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class UserScheduleRecordRepository extends DynamoDbRepository<UserScheduleRecordEntity> {

    public UserScheduleRecordRepository(DynamoDbTable<UserScheduleRecordEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }

    public void delete(String userId, String scheduleId) {
        super.deleteItem(userId, scheduleId);
    }
}
