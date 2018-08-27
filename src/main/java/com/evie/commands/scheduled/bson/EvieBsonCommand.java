package com.evie.commands.scheduled.bson;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by rmhedge on 4/4/17.
 */
public class EvieBsonCommand {

    protected Map<String,Object> keyValPairs;
    protected String collectionName;

    public EvieBsonCommand () {

    }
    public EvieBsonCommand(String collectionName) {
        keyValPairs = new HashMap<String,Object>();
    }

    public BasicDBObject generateBasicDbObject() {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start(commandKey(),collectionName);
        for(String key:keyValPairs.keySet()) {
            builder.append(key,keyValPairs.get(key));
        }
       return (BasicDBObject)builder.get();
    }

    public Document toDocument() {
        BsonDocument bsonDocument = new BsonDocument();
        for(String key:keyValPairs.keySet()) {
            //   bsonDocument.put(key,keyValPairs.get(key));
        }
        return null;
    }

    public String commandKey() {
        return "DEFAULT_KEY";
    }

}
