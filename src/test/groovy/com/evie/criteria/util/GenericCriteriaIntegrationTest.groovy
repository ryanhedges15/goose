package com.evie.criteria.util

import com.evie.test.util.domain.SampleRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
class GenericCriteriaIntegrationTest extends Specification {

    @Autowired
    MongoTemplate mongoTemplate

    def "test the container"() {
        setup:
        def foo = "";
        when:
        foo = "bar"
        then:
        mongoTemplate != null
    }

    List<SampleRecord> getSampleRecords(int numRecords) {

        localDate = LocalDate.now()
        numRecords.times {
            LocalDate otherDate = localDate.minusDays(1)
            localDate = otherDate.clone()

            SampleRecord sampleRecord = new SampleRecord()

        }

    }


}
