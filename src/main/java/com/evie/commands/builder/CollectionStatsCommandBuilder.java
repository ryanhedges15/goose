package com.evie.commands.builder;
import javafx.util.Pair;

/**
 * Created by Shannon Hedges 7/26/17.
 */

public class CollectionStatsCommandBuilder extends AbstractCommandBuilder {

    private String collName = null;

    public CollectionStatsCommandBuilder(String collName){
        super();
        this.collName = collName;
    }

    public CollectionStatsCommandBuilder scale(int scale) {
        this.keyValPairs.put("scale",scale);
         return this;
    }

    public CollectionStatsCommandBuilder verbose(boolean verbose) {
         this.keyValPairs.put("verbose", verbose);
        return this;
    }

    public Pair<String,String> getCommandPair() {
        return new Pair<String,String>("collStats", collName);
    }

}
