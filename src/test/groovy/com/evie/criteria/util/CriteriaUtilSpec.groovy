package com.evie.criteria.util

import com.evie.criteria.util.enumueration.CriteriaOperator
import com.evie.criteria.util.enumueration.MongoType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by rmhedge on 8/2/17.
 */
@Unroll
class CriteriaUtilSpec extends Specification {

    def classUnderTest =  new UriParameterUtil()

    def "When #input is passed in #outputType is produced"() {
        given:
        UriParameterUtil.guessType(input)

        where:
        input   || outputType
        "foo"   || MongoType.STRING
        "8"     || MongoType.INTEGER
        "8.0"   || MongoType.DOUBLE
        "fo.o"  || MongoType.STRING
        "8.0.0" || MongoType.STRING
    }

    def "When a #params #outputType is returned"() {
        ;
        given:
        UriParameterUtil.treatAs(params)

        where:
        params                          || outputType
        getCaseByName("allStrings")     || MongoType.STRING
        getCaseByName("someStrings")    || MongoType.STRING
        getCaseByName("doublesAndInts") || MongoType.DOUBLE
        getCaseByName("int")            || MongoType.INTEGER
        getCaseByName("double")         || MongoType.DOUBLE

    }

    def getCaseByName(String name) {
        def string1 = "a"
        def string2 = "b"
        def string3 = "0.0.0.0"
        def decimal = "1.0"
        def integer = "1000"
        MultiValueMap<CriteriaOperator, String> inputVals = new LinkedMultiValueMap<>()

        switch (name) {
            case "allStrings":
                inputVals.add(CriteriaOperator.EQUAL, string1)
                inputVals.add(CriteriaOperator.EQUAL, string2)
                inputVals.add(CriteriaOperator.EQUAL, string3)
                break
            case "someStrings":
                inputVals.add(CriteriaOperator.EQUAL, string1)
                inputVals.add(CriteriaOperator.EQUAL, integer)
                break
            case "doublesAndInts":
                inputVals.add(CriteriaOperator.EQUAL, integer)
                inputVals.add(CriteriaOperator.EQUAL, decimal)
                break
            case "int":
                inputVals.add(CriteriaOperator.EQUAL, integer)
                break
            case "double":
                inputVals.add(CriteriaOperator.EQUAL, decimal)
                break
        }
        return inputVals

    }

}
