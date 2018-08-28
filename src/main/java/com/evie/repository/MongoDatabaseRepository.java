package com.evie.repository;


import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by rmhedge on 3/18/17.
 */
@Repository
public class MongoDatabaseRepository {

    private static final Logger log = LoggerFactory.getLogger(MongoDatabaseRepository.class);

    @Autowired
    MongoClient mongoClient;

}
