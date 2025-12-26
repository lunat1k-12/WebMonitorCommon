package com.web.monitor.common.dao.repository;

import java.util.Map;
import com.web.monitor.common.dao.entity.UserPaymentEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbIndex;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Slf4j
public class UserPaymentRepository extends DynamoDbRepository<UserPaymentEntity> {

    private static final String PAGINATED_INDEX_NAME = "paginatedIndex";

    public UserPaymentRepository(DynamoDbTable<UserPaymentEntity> dynamoDbTable) {
        super(dynamoDbTable);
    }

    public Page<UserPaymentEntity> queryPaginatedByIndex(String partitionKey, Map<String, AttributeValue> lastEvaluatedKey, int pageSize) {
        log.info("Querying payments by global index: index={}, partitionKey={}", PAGINATED_INDEX_NAME, partitionKey);
        try {
            DynamoDbIndex<UserPaymentEntity> index = dynamoDbTable.index(PAGINATED_INDEX_NAME);

            QueryConditional partitionKeyCondition = QueryConditional.keyEqualTo(
                    Key.builder().partitionValue(partitionKey)
                            .build());

            QueryEnhancedRequest.Builder requestBuilder = QueryEnhancedRequest.builder()
                    .queryConditional(partitionKeyCondition)
                    .limit(pageSize)
                    .scanIndexForward(false); // Sort by sort key in descending order

            if (lastEvaluatedKey != null) {
                requestBuilder.exclusiveStartKey(lastEvaluatedKey);
            }

            return index.query(requestBuilder.build()).stream().findFirst().orElse(null);
        } catch (Exception e) {
            log.error("Error querying entities by global index: index={}, partitionKey={}",
                    PAGINATED_INDEX_NAME, partitionKey, e);
            throw new RuntimeException("Failed to query entities by global index", e);
        }
    }
}
