package org.sample.aws.serverless.phobias;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class PhobiaGetOne implements RequestHandler<Phobia, String> {

    LambdaLogger logger;

    @Override
    public String handleRequest(Phobia request, Context context) {
        
        System.out.println("Request: " + request);

        Item outcome = DynamoDBUtil.getTable().getItem(new PrimaryKey("meaning", request.getMeaning()));
        if (null != outcome) {
            return outcome.getString("word");
        }
        return null;
    }
}
