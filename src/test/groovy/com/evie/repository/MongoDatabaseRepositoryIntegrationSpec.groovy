package com.evie.repository

import com.evie.commands.builder.DbStatsCommandBuilder
import com.evie.commands.scheduled.bson.DbStatsCommand
import com.mongodb.BasicDBObject
import com.mongodb.CommandResult
import com.mongodb.DBObject
import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rmhedge on 3/19/17.
 */
@ContextConfiguration
@SpringBootTest
class MongoDatabaseRepositoryIntegrationSpec extends Specification {

    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository

    @Autowired
    MongoClient mongoClient

    def "test to see if"() {

        when:
        def db = mongoClient.getDatabase("test")
        final DBObject command = new BasicDBObject();
        //command.put("eval", "function() { return db." + "people" + ".findOne(); }");
        command.put("eval", "{return db.printCollectionStats()}");
        CommandResult result = db.runCommand(command);

        then:
        true==true
    }
}
