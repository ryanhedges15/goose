package com.evie.criteria.util.processors

import com.evie.criteria.util.domain.MongostatRecord
import com.evie.criteria.util.domain.MonitoringRecord
import groovy.json.JsonSlurper
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/** Processes a single line of mongostat output. This is an entire mongostat record.
 * Created by rmhedge on 4/9/16.
 */
class MongoStatLineProcessor implements LineProcessor {

    Logger logger = LoggerFactory.getLogger(MongoStatLineProcessor.class)

    JsonSlurper slurper = new JsonSlurper();

    public MongoStatLineProcessor() {

    }

    @Override
    MonitoringRecord processLine(String line) {
        logger.info("processing: ${line}");
        def result = slurper.parseText(line);
        MongostatRecord msr = new MongostatRecord();
        List<String> fieldsWithAsterisks = new ArrayList<String>();
        msr.setFieldsWithAsterisk(fieldsWithAsterisks);

        result.each { it ->
            def curr = it.value
            curr.keySet().each { currSubKey ->
                String currItem = curr.get(currSubKey);
                if (currSubKey.equals("ar|aw")) {
                    String[] items = currItem.split('|');
                    msr.activeClientsReading = stripAsterisk(items[0], "activeClientsReading", fieldsWithAsterisks);
                    msr.activeClientsWriting = stripAsterisk(items[2], "activeClientsWriting", fieldsWithAsterisks);
                } else if (currSubKey.equals("command")) {
                    String[] items = currItem.split('|');
                    msr.numberLocalCommands = stripAsterisk(items[0], "numberCommands", fieldsWithAsterisks);
                    msr.numberReplicatedCommands = stripAsterisk(items[2], "numberCommands", fieldsWithAsterisks);
                } else if (currSubKey.equals("conn")) {
                    msr.numberConnections = stripAsterisk(currItem, "numberConnections", fieldsWithAsterisks);
                } else if (currSubKey.equals("delete")) {
                    msr.numberDeletes = stripAsterisk(currItem, "numberDeletes", fieldsWithAsterisks);
                } else if (currSubKey.equals("flushes")) {
                    msr.numberFlushes = stripAsterisk(currItem, "numberFlushes", fieldsWithAsterisks);
                } else if (currSubKey.equals("getmore")) {
                    msr.numberGetmore = stripAsterisk(currItem, "numberGetmore", fieldsWithAsterisks);
                } else if (currSubKey.equals("host")) {
                    msr.host = currItem;
                } else if (currSubKey.equals("insert")) {
                    msr.numberInserts = stripAsterisk(currItem, "numberInserts", fieldsWithAsterisks);
                } else if (currSubKey.equals("netIn")) {
                    def netIn = currItem;
                    msr.networkTrafficIn = convertShorthandSizesToByteCount(netIn);
                } else if (currSubKey.equals("netOut")) {
                    def netOut = currItem;
                    msr.networkTrafficOut = convertShorthandSizesToByteCount(netOut);
                } else if (currSubKey.equals("qr|qw")) {
                    String[] items = currItem.split('|');
                    msr.queuedReads = stripAsterisk(items[0], "queuedReads", fieldsWithAsterisks);
                    msr.queuedWrires = stripAsterisk(items[2], "queuedWrites", fieldsWithAsterisks);
                } else if (currSubKey.equals("query")) {
                    msr.numberQueries = stripAsterisk(currItem, "numberQueries", fieldsWithAsterisks);
                } else if (currSubKey.equals("res")) {
                    //TODO convert to bytes
                    msr.residentMegabytes = convertShorthandSizesToByteCount(currItem);
                } else if (currSubKey.equals("time")) {
                    //TODO time
                    println(curr.get(currSubKey));
                } else if (currSubKey.equals("update")) {
                    msr.numberUpdates = stripAsterisk(currItem, "numberUpdates", fieldsWithAsterisks);
                } else if (currSubKey.equals("vsize")) {
                    msr.virtualMemorySize = convertShorthandSizesToByteCount(currItem)
                }

            }


        }
        return msr;
    }
    /*
    Mongo docs aren't really clear on what the asterisk is for for all fields. The documentation says it is for replicated operations but I'm not sure whay that is valuable.
    For now I am just going to throw the fields with an asterisk in list and preserve them but keep them separate from the core document.
     */

    private int stripAsterisk(String source, String label, List<String> fieldsWithAsterisk) {
        if (source.contains('*')) {
            fieldsWithAsterisk.add(label);
            return Integer.parseInt(source.replace("*", ""));
        } else {
            return Integer.parseInt(source);
        }
    }

    private double convertShorthandSizesToByteCount(final String sizeString) {
        String lastChar = sizeString.charAt(sizeString.length() - 1);
        String truncatedString = sizeString.substring(0, sizeString.length() - 1);
        double size = Double.parseDouble(truncatedString);
        if (lastChar.equalsIgnoreCase('b')) {
            return size;

        } else if (lastChar.equalsIgnoreCase('k')) {
            return size * 1024;
        } else if (lastChar.equalsIgnoreCase('m')) {
            return size * 1024 * 1024
        } else if (lastChar.equalsIgnoreCase('g')) {
            return size * 1024 * 1024 * 1024;
        }
    }



}
