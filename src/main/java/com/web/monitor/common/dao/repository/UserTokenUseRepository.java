package com.web.monitor.common.dao.repository;

import java.util.Map;
import com.web.monitor.common.dao.entity.UserTokenUseEntity;
import com.web.monitor.common.dao.repository.base.DynamoDbRepository;
import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

@Log4j2
public class UserTokenUseRepository extends DynamoDbRepository<UserTokenUseEntity> {

    private static final String TABLE_NAME = "UserTokenUser";
    private final DynamoDbClient dynamoDbClient;

    public UserTokenUseRepository(DynamoDbTable<UserTokenUseEntity> dynamoDbTable, DynamoDbClient client) {
        super(dynamoDbTable);
        this.dynamoDbClient = client;
    }

    public void incrementTokens(String userId, Integer inputTokens, Integer outputTokens) {
        log.info("Increment request count for {}", userId);
        Map<String, AttributeValue> key = Map.of(
                "userId", AttributeValue.fromS(userId));

        Map<String, AttributeValue> expressionValues = Map.of(
                ":inToken", AttributeValue.fromN(inputTokens.toString()),
                ":outToken", AttributeValue.fromN(outputTokens.toString()));

        UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(key)
                .updateExpression(
                        "SET InputTokens = InputTokens + :inToken, OutputTokens = OutputTokens + :outToken")
                .expressionAttributeValues(expressionValues)
                .build();

        dynamoDbClient.updateItem(updateRequest);
    }
}
