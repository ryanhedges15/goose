package com.evie.criteria.util.service

import com.evie.commands.scheduled.Command
import com.evie.criteria.util.processors.LineProcessor

import java.sql.Timestamp

/**
 * Created by rmhedge on 4/9/16.
 */
class LongRunningCommandRunner implements Runnable {

    Command command;
    LineProcessor lineProcessor;
    Timestamp lastRun;

    public LongRunningCommandRunner(Command c) {
        command = c;
        lineProcessor = c.getLineProcessor();
    }


    void run() {
        String[] commandArr = command.getAsArray();
        def process = new ProcessBuilder(commandArr).redirectErrorStream(false).start();
        process.inputStream.eachLine {
            lineProcessor.processLine(it);
            lastRun = new Timestamp(System.currentTimeMillis());
        }

    }

    String[] getCommand() {
        return command
    }

    LineProcessor getLineProcessor() {
        return lineProcessor
    }

    void setLineProcessor(LineProcessor lineProcessor) {
        this.lineProcessor = lineProcessor
    }

    Timestamp getLastRun() {
        return lastRun
    }

}
