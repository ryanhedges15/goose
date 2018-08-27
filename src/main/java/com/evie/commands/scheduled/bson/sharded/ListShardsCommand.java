package com.evie.commands.scheduled.bson.sharded;

import com.evie.commands.scheduled.bson.EvieBsonCommand;

/**
 * Created by rmhedge on 4/4/17.
 */
public class ListShardsCommand extends EvieBsonCommand {

    public ListShardsCommand(){
        super();
        this.keyValPairs.put("listShards",1);
    }

}
