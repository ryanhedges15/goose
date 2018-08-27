package com.evie.service;

import com.evie.commands.builder.DbStatsCommandBuilder;
import com.evie.domain.DbStats;
import com.evie.domain.EvieMongoDatabase;
import com.evie.repository.DbStatsMongoRepository;
import com.evie.repository.MongoDatabaseRepository;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rmhedge on 7/29/17.
 */
@Service
public class DbStatsCommandService {

    Logger log = LoggerFactory.getLogger(DbStatsCommandService.class);

    @Autowired
    DbStatsMongoRepository dbStatsMongoRepository;

    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository;

    public void pullCurrentDbStats() {
       List<EvieMongoDatabase> databaseList = mongoDatabaseRepository.findAllDatabases();
       for(EvieMongoDatabase database:databaseList) {
           BasicDBObject command = new DbStatsCommandBuilder(database.getDatabaseName()).scale(1).build();
           Document result = mongoDatabaseRepository.executeCommand(database.getDatabaseName(),command);
           DbStats curr = convertDbStatsToDomainObject(result);
           dbStatsMongoRepository.save(curr);
       }
    }

    private DbStats convertDbStatsToDomainObject(Document doc) {
        log.info(doc.toString());
        DbStats stats = new DbStats();
        stats.setDatabaseName(doc.getString("db"));
        stats.setAverageObjectSize(doc.getDouble("avgObjSize"));
        stats.setSizeInBytes(doc.getDouble("dataSize"));
        stats.setStorageSize(doc.getDouble("storageSize"));
        stats.setNumIndexes(doc.getInteger("indexes"));
        stats.setIndexSizeInBytes(doc.getDouble("indexSize"));
        return stats;
    }



}
