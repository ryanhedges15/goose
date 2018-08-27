package com.evie.service.scheduled;

import com.evie.service.DbStatsCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/** Queries and saves off statistics about the database on an interval
 * Created by rmhedge on 7/29/17.
 */
@Service
public class DbStatsSchedulerService {

    private static Logger log = LoggerFactory.getLogger(DbStatsSchedulerService.class);

    @Autowired
    private DbStatsCommandService dbStatsCommandService;

    /**
     * Runs every 15 min to log database sizes
     */
    @Scheduled(fixedDelay = 60000L,initialDelay = 30000L)
    public void saveDbStats() {
        log.info("Pulling dbStats");
        dbStatsCommandService.pullCurrentDbStats();
        log.info("Finished pulling dbStats");
    }

}
