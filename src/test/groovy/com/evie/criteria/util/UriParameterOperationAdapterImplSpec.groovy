package com.evie.criteria.util

import com.evie.criteria.util.enumueration.CriteriaOperator
import com.evie.criteria.util.enumueration.MongoType
import javafx.util.Pair
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by rmhedge on 8/6/17.
 */
@Unroll
class UriParameterOperationAdapterImplSpec extends Specification {

    UriParameterOperationAdapter classUnderTest = new UriParameterOperationAdapterImpl()

    def "When param key is #key and value is #value then use #operator" () {
        given:
        Pair<CriteriaOperator,String> output = classUnderTest.parseFromUriValue(key,value)

        expect:
        output.key == operator
        //All key operators should have been removed
        !output.value.contains(")")
        !output.value.contains("lt(")
        !output.value.contains("lte(")
        !output.value.contains("gt(")
        !output.value.contains("gte(")


        where:
        key | value || operator
        "foo" | "b*r" ||CriteriaOperator.LIKE
        "foo" | "bar" | CriteriaOperator.EQUAL
        "foo" | "b**ar"| CriteriaOperator.LIKE_IGNORE_CASE
        "foo!"| "bar" | CriteriaOperator.NOT_EQUAL
        "foo" | "gt(4)" | CriteriaOperator.GREATER_THAN
        "foo" | "gte(4)" | CriteriaOperator.GREATER_THAN_OR_EQUAL
        "foo!"| "gte(5)" | CriteriaOperator.LESS_THAN
        "foo!"| "gt(5)"  | CriteriaOperator.LESS_THAN_OR_EQUAL
        "foo" | "lt(4)" | CriteriaOperator.LESS_THAN
        "foo" | "lte(4)" | CriteriaOperator.LESS_THAN_OR_EQUAL
        "foo!"| "lte(5)" | CriteriaOperator.GREATER_THAN
        "foo!"| "lt(5)"  | CriteriaOperator.GREATER_THAN_OR_EQUAL
    }
}
