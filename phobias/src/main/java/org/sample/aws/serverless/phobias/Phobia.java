package org.sample.aws.serverless.phobias;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author arungupta
 */
@DynamoDBTable(tableName = "Phobias")
public class Phobia {

    private String meaning;
    private String word;
    
    public Phobia() { }

    public Phobia(String meaning, String word) {
        this.meaning = meaning;
        this.word = word;
    }

    @DynamoDBHashKey
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    
    @DynamoDBAttribute
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Phobia{" + "meaning=" + meaning + ", word=" + word + '}';
    }
}
