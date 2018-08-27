package com.evie.criteria.util
/**
 * Created by rmhedge on 4/9/16.
 */
class CommandBuilder {

    public static String[] build(String command, String... args) {
        String[] fullCommand = new String[args.length+1];
        fullCommand[0] = command;
        for(int i=0 ; i < args.length; i++) {
            fullCommand[i+1] = args[i];
        }
        return fullCommand;
    }

}
