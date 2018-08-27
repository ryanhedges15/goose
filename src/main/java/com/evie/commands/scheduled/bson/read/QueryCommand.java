package com.evie.commands.scheduled.bson.read;

import com.evie.commands.scheduled.bson.EvieBsonCommand;

/** From https://docs.mongodb.com/manual/reference/command/nav-crud/
 * Created by rmhedge on 4/4/17.
 */
public class QueryCommand extends EvieBsonCommand {

    public QueryCommand(){
        super();
        this.keyValPairs.put("find",1);
    }

}
