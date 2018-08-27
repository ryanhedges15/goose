package com.evie.configuration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientConfiguration {

    @Bean
    @ConditionalOnBean(name="mongoClient")
    public MongoClient mongoClient() {
        return new MongoClient(new ServerAddress("localhost",27017));
    }
}
