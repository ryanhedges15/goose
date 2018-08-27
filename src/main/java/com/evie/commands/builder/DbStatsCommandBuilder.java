package com.evie.commands.builder;

import com.evie.commands.scheduled.bson.EvieBsonCommand;
import javafx.util.Pair;

/**
 * Created by rmhedge on 4/4/17.
 */
public class DbStatsCommandBuilder extends AbstractCommandBuilder {

    private String databaseName = null;

    public DbStatsCommandBuilder(String databaseName){
        super();
        this.databaseName = databaseName;
    }

    public DbStatsCommandBuilder scale(int scale) {
        this.keyValPairs.put("scale",scale);
        return this;
    }

    public Pair<String,Integer> getCommandPair() {
        return new Pair<String,Integer>("dbStats",1);
    }

}
