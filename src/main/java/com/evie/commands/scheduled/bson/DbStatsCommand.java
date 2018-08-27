package com.evie.commands.scheduled.bson;

/**
 * Created by rmhedge on 4/4/17.
 */
public class DbStatsCommand extends EvieBsonCommand {

    public DbStatsCommand(String collectionName,int scale){
        super(collectionName);
        this.keyValPairs.put("scale",scale);
    }

    @Override
    public String commandKey() {
        return "dbStats";
    }

}
