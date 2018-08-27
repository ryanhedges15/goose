package com.evie.test.util.configuration

import com.evie.configuration.MongoClientConfiguration
import com.mongodb.MongoClient
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
@AutoConfigureBefore(MongoClientConfiguration)
class FlapdoodleMongoConfiguration {

    private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "embeded_db";

    @Bean
    EmbeddedMongoFactoryBean embeddedMongoFactoryBean() {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean()
        mongo.setBindIp(MONGO_DB_URL);
        return mongo
    }

    @Bean
    MongoClient mongoClient(EmbeddedMongoFactoryBean mongo) {
       return mongo.getObject()
    }

    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient) throws IOException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
        return mongoTemplate
    }

}