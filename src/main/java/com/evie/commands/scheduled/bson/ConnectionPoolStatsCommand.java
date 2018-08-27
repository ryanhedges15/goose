package com.evie.commands.scheduled.bson;

/**
 * Created by rmhedge on 4/4/17.
 */
public class ConnectionPoolStatsCommand extends EvieBsonCommand {

    public ConnectionPoolStatsCommand(){
        super();
        this.keyValPairs.put("connPoolStats",1);
    }

}
