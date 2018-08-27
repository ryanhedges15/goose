package com.evie.service;

import com.evie.repository.MongoDatabaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * Created by rmhedge on 7/23/17.
 */
@Service
public class MongoCollectionMonitoringService {

    private static final Logger log = LoggerFactory.getLogger(MongoCollectionMonitoringService.class);

    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository;

    @Scheduled(fixedDelay = 10000L)
    public void runCollectionUpdate() {
        log.info("Scheduled Item Running ");
      //  mongoDatabaseRepository.findCollectionsByDatabaseName("test");
    }
}
