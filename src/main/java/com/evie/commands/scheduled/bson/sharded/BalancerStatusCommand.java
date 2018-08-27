package com.evie.commands.scheduled.bson.sharded;

import com.evie.commands.scheduled.bson.EvieBsonCommand;

/**
 * Created by rmhedge on 4/4/17.
 */
public class BalancerStatusCommand extends EvieBsonCommand {

    public BalancerStatusCommand(){
        super();
        this.keyValPairs.put("balancerStatus",1);
    }

}
