package com.evie.repository;

import com.evie.criteria.util.enumueration.AccumulatorOperator;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import groovy.util.logging.Slf4j;
import org.bson.BsonDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmhedge on 7/30/17.
 */
@Repository
public class MongoMetricsRespository {

    Logger log = LoggerFactory.getLogger(MongoDatabaseRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoClient mongoClient;

    public List<BsonDocument> findAndProduceMetrics(String collectionName,MultiValueMap<String,String> multiValueMap,List<String> groupingFields, AccumulatorOperator operator) {
        return null;
    }

    public List<DBObject> findByCriteria(String collectionName, Criteria criteria) {
        if(criteria==null){
            return new ArrayList<>();
        }
        else if(collectionName == null) {
            throw new IllegalArgumentException("Collection name was null. Unable to run query.");
        }
        Query query = new Query(criteria);
        log.debug("Generated query was:" + query.toString());
        return mongoTemplate.find(query, DBObject.class,collectionName);
    }
}
