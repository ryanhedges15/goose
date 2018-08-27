package com.evie.commands.builder;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmhedge on 7/24/17.
 */
public abstract class AbstractCommandBuilder<T> {

    protected Map<String,Object> keyValPairs;

    public AbstractCommandBuilder() {
        keyValPairs = new HashMap<String,Object>();
    }

    public BasicDBObject build() {
        Pair<String,T> commandePair = this.getCommandPair();
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start(commandePair.getKey(),commandePair.getValue());
        for(String key:keyValPairs.keySet()) {
            builder.append(key,keyValPairs.get(key));
        }
        return (BasicDBObject)builder.get();
    }

    abstract Pair<String,T> getCommandPair();
}
