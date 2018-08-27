package com.evie.commands.scheduled;

import com.evie.criteria.util.processors.LineProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by rmhedge on 4/22/16.
 */
@Component
class MongostatCommand extends Command {
    @Override
    public String[] getAsArray(String... args) {
        return super.getAsArray(args);
    }

    @Override
    public boolean isConfiguredToRun() {
        return super.isConfiguredToRun();
    }

    @Override
    public LineProcessor getLineProcessor() {
        return null;
    }

}

/*
    private String port;

    private boolean discover;

    private String delay;

    public MongostatCommand() {
        Object.commandString = 'mongostat';
    }


    String[] getAsArray() {
        if(discover) {
            return Object.getAsArray(delay,"--port", port,"--discover","--json");
        }
        else {
            return Object.getAsArray(delay,"--port", port,"--json");
        }
    }

    public setConfiguredToRun(boolean run) {
        Object.configuredToRun = run;
    }

    public LineProcessor getLineProcessor() {
        return new MongoStatLineProcessor();
    }
*/
