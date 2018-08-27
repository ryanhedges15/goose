package com.evie.commands.builder;

import javafx.util.Pair;

/**
 * Created by rmhedge on 4/4/17.
 */
public class CurrentOpCommandBuilder extends AbstractCommandBuilder {


    public CurrentOpCommandBuilder(){
        super();
    }

    public Pair<String,String> getCommandPair() {
        return new Pair<String,String>("currentOp","admin");
    }

}
