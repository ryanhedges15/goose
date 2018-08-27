package com.evie.commands.scheduled;

import com.evie.criteria.util.processors.LineProcessor;

import java.util.Map;

/**
 * Created by rmhedge on 4/22/16.
 */
public abstract class Command {

    protected String commandString;
    protected Map<String,String> arguments;
    protected boolean configuredToRun;


    public  String[] getAsArray(String... args) {
        String[] fullCommand = new String[args.length+1];
        fullCommand[0] = commandString;
        for(int i=0 ; i < args.length; i++) {
            fullCommand[i+1] = args[i];
        }
        return fullCommand;
    }

    public boolean isConfiguredToRun() {
        return configuredToRun;
    }

    public abstract LineProcessor getLineProcessor();

}
