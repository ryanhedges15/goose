package com.evie.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rmhedge on 3/19/17.
 */
@ContextConfiguration
@SpringBootTest
@Slf4j
class ScheduledCommandMapServiceIntegrationSpec extends Specification {

    @Autowired
    ScheduledCommandMapService commandMapService;


    def "test to see if"() {

        when:
        log.info("foo")

        then:
        true
    }
}
