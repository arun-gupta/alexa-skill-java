package org.sample.aws.serverless.phobias;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

/**
 * @author arungupta
 */
public class PhobiaGetAll implements RequestHandler<Phobia, String> {

    @Override
    public String handleRequest(Phobia request, Context context) {
    	ScanRequest scanRequest = new ScanRequest().withTableName("Phobias");
    	ScanResult result = DynamoDBUtil.getClient().scan(scanRequest);
        System.out.println("-- phobias listing start --");
    	for (Map<String, AttributeValue> item : result.getItems()){
    	    System.out.println(item);
    	}
        System.out.println("-- phobias listing end --");
        return result.getItems().toString();
    }
}
