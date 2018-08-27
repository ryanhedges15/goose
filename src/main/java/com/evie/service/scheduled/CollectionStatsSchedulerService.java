package com.evie.service.scheduled;

import com.evie.service.CollectionStatsCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Queries and saves off statistics about the database on an interval
 * Created by Shannon Hedges 7/31/2017
 */
@Service
public class CollectionStatsSchedulerService {

    private static Logger log = LoggerFactory.getLogger(CollectionStatsSchedulerService.class);

    @Autowired
    private CollectionStatsCommandService collectionStatsCommandService;


    /**
     * Execute the annotated method with a fixed period in milliseconds between
     * invocations to log collection stats.
     */
    @Scheduled(fixedDelay = 60000L,initialDelay = 30000L)
    public void saveCollectionStats(){
        log.info("Pulling CollectionStats");
        collectionStatsCommandService.pullCurrentCollectionStats();
        log.info("Finished pulling CollectionStats");
    }




}

