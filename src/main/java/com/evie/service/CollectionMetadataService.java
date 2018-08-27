package com.evie.service;

import com.evie.domain.EvieMongoCollection;
import com.evie.repository.MongoDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rmhedge on 7/18/17.
 */
@Service
public class CollectionMetadataService {

    @Autowired
    private MongoDatabaseRepository mongoDatabaseRepository;

    public List<EvieMongoCollection> findCollectionsByDatabaseName(String databaseName) {
       return mongoDatabaseRepository.findCollectionsByDatabaseName(databaseName);
    }
    public EvieMongoCollection findCollectionByDatabaseAndCollectionName(String databaseName,String collectionName) {
        EvieMongoCollection mongoCollection = new EvieMongoCollection();
        mongoCollection.setCollectonName(collectionName);
        mongoCollection.setNamespace("one");
        mongoCollection.setCollectionSize("100");
        mongoCollection.setCollectionCount("100");
        return mongoCollection;
    }
}
