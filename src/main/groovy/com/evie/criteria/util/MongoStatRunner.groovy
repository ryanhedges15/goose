package com.evie.criteria.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * Created by rmhedge on 3/3/16.
 */
class MongoStatRunner implements Runnable {

    Logger log = LoggerFactory.getLogger(MongoStatRunner.class);

    void run() {
        log.info("Startting mongostat ");
        def is = 'mongostat --json'.execute().getInputStream();
        Scanner scanner = new Scanner(is);

        log.info("waiting for response from procrss");

        while(true) {
            log.info("Checking for data");

            if(scanner.hasNextLine()) {
                log.info("line:${scanner.nextLine()}");
            }
            else Thread.sleep(400);

        }


    }

}
