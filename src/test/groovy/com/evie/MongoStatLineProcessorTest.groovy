package com.evie

import com.evie.criteria.util.processors.MongoStatLineProcessor
import spock.lang.Specification

/**
 * Created by rmhedge on 4/24/16.
 */
class MongoStatLineProcessorTest extends Specification {

    File testResource = new File('src/test/resources/mongostat.txt')
    def classUnderTest = new MongoStatLineProcessor()

    def "processing mongostat nice case"() {
        setup:
        List<String> lines = new ArrayList<String>()
        testResource.text.eachLine { line ->
            lines.add(line)
        }
        when:
        def result = classUnderTest.processLine(lines.get(0));
        then:
        print("hello")
    }


}
