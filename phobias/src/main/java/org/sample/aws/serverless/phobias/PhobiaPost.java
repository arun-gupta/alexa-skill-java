package org.sample.aws.serverless.phobias;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class PhobiaPost implements RequestHandler<Phobia, String> {

    @Override
    public String handleRequest(Phobia request, Context context) {
    	DynamoDBMapper mapper = new DynamoDBMapper(DynamoDBUtil.getClient());
    	mapper.save(request);

    	return "success";
    }
    
}
