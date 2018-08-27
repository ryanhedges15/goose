package com.evie.service;

import com.evie.commands.builder.CollectionStatsCommandBuilder;
import com.evie.commands.builder.DbStatsCommandBuilder;
import com.evie.commands.scheduled.bson.CollectionStatsCommand;
import com.evie.domain.CollectionStats;
import com.evie.domain.DbStats;
import com.evie.domain.EvieMongoCollection;
import com.evie.domain.EvieMongoDatabase;
import com.evie.repository.CollectionStatsMongoRepository;
import com.evie.repository.DbStatsMongoRepository;
import com.evie.repository.MongoDatabaseRepository;
import com.evie.service.scheduled.CollectionStatsSchedulerService;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shannon Hedges on 7/29/17.
 */
@Service
public class CollectionStatsCommandService {

    private static Logger log = LoggerFactory.getLogger(DbStatsCommandService.class);

    @Autowired
    CollectionStatsMongoRepository collectionStatsMongoRepository;
    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository;


    public void pullCurrentCollectionStats() {
        List<EvieMongoDatabase> databaseList = mongoDatabaseRepository.findAllDatabases();
        for (EvieMongoDatabase database : databaseList) {
            System.out.println(database.getDatabaseName());
            List<EvieMongoCollection> collectionList = mongoDatabaseRepository.findCollectionsByDatabaseName(database.getDatabaseName());
            for (EvieMongoCollection collection : collectionList) {
                System.out.println(collection.getCollectonName());
                BasicDBObject command = new CollectionStatsCommandBuilder(collection.getCollectonName()).scale(1).build();
                Document result = mongoDatabaseRepository.executeCommand(database.getDatabaseName(),command);
                CollectionStats curr = convertCollStatsToDomainObject(result);
                collectionStatsMongoRepository.save(curr);
            }

        }
    }

    private CollectionStats convertCollStatsToDomainObject(Document doc) {
        log.info(doc.toString());
        CollectionStats stats = new CollectionStats();
        stats.setTotalIndexSize(doc.getInteger("totalIndexSize"));
        stats.setSize(doc.getInteger("size"));
        stats.setAvgObjSize(doc.getInteger("avgObjSize"));
        stats.setStorageSize(doc.getInteger("storageSize"));
        return stats;
    }
}
