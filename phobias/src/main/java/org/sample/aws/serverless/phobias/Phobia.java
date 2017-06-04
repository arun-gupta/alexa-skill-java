package org.sample.aws.serverless.phobias;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author arungupta
 */
@DynamoDBTable(tableName = "Phobias")
public class Phobia {

    private String word;
    private String meaning;
    
    public Phobia() { }

    public Phobia(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
