package com.evie.commands.scheduled.bson;

/**
 * Created by rmhedge on 4/4/17.
 */
public class CollectionStatsCommand extends EvieBsonCommand {

    public CollectionStatsCommand(String collection, int scale, boolean verbose){
        super();
        this.keyValPairs.put("collName",collection);
        this.keyValPairs.put("scale",1);
        this.keyValPairs.put("verbose",verbose);
    }

}
