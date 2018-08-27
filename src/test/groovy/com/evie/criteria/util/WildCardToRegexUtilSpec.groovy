package com.evie.criteria.util

import spock.lang.Specification
import spock.lang.Unroll

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by rmhedge on 8/5/17.
 */
@Unroll
class WildCardToRegexUtilSpec extends Specification {

    def "Wildcard value #wildcard matches #expectedMatch "() {
        when:
        Pattern output = WildCardToRegexUtil.buildPatternFromWildCardedString(wildcard,false)

        then:
        output.matcher(expectedMatch).matches()

        where:
        wildcard | expectedMatch
        "*"    | "foo"
        "*b*"  | "rabbit"
        "foo*" | "food"
        "f*n*r" | "funnier"
    }

    def "Wildcard value #wildcard does not match #expectedMismatch "() {
        when:
        Pattern output = WildCardToRegexUtil.buildPatternFromWildCardedString(wildcard,false)

        then:
        !output.matcher(expectedMismatch).matches()

        where:
        wildcard | expectedMismatch
        "*f"    | "foo"
        "f*f"   | "ferret"
        "*p"    | "happy"

    }

    def "Wildcarded OR matches #expectedMatch "() {
        when:
        Pattern output = WildCardToRegexUtil.buildPatternFromWildCardedStrings(wildcard,false)

        then:
        output.matcher(expectedMatch).matches()

        where:
        wildcard | expectedMatch
        ["g*","f*"]| "foo"
        ["*foo","bar*","app*j"] | "foo"

    }

    def "Wildcarded OR does not match #expectedMismatch "() {
        when:
        Pattern output = WildCardToRegexUtil.buildPatternFromWildCardedStrings(wildcard,false)

        then:
        !output.matcher(expectedMismatch).matches()
        expectedMismatch==expectedMismatch

        where:
        wildcard | expectedMismatch
        ["g*","f*"]| "apple"
        ["*foo","bar*","app*e"] | "james"

    }

    def "Case insensitive wildcard value #wildcard matches  #expectedMatch "() {
        when:
        Pattern output = WildCardToRegexUtil.buildPatternFromWildCardedString(wildcard,true)

        then:
        output.matcher(expectedMatch).matches()

        where:
        wildcard | expectedMatch
        "f*"    | "Foo"
        "*bb*"  | "raBBit"
        "foo*" | "FOOD"
        "f*n*r" | "FUNNIER"
    }
}
