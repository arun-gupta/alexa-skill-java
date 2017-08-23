package org.sample.aws.alexa.hello;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * @author Arun Gupta
 */
public class DBUtil {

    private static AmazonDynamoDB dynamodbClient;

    private static AmazonDynamoDB getClient() {
        if (null != dynamodbClient) {
            return dynamodbClient;
        }

        String region = System.getProperty("DYNAMODB_REGION");
        if (null == region) {
            System.err.println("Region not set, default \"" + Regions.US_EAST_1.name() + "\" is used");
            region = Regions.US_EAST_1.name();
        }
        System.out.println("DynamoDB region: " + region);

        dynamodbClient = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();

        return dynamodbClient;
    }

    public static Person getPerson(String id) {
        DynamoDBMapper mapper = new DynamoDBMapper(getClient());
        return mapper.load(Person.class, id);
    }
}
