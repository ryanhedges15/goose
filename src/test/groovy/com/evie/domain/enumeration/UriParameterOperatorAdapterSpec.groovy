package com.evie.domain.enumeration

import com.evie.criteria.util.UriParameterOperationAdapter
import com.evie.criteria.util.enumueration.CriteriaOperator
import javafx.util.Pair
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by rmhedge on 7/31/17.
 */
@Unroll
class UriParameterOperatorAdapterSpec extends Specification {

    def "Test when input is #input the proper operation isidentified "() {
        expect:
        UriParameterOperationAdapter.parseFromUriValue(key,input);

        where:
       key| input || output
       "irrelevant"|  "foo" || new Pair<CriteriaOperator,String>(CriteriaOperator.EQUAL,"foo")
        "irrelevant"| "gte(6)" || new Pair<CriteriaOperator,String>(CriteriaOperator.GREATER_THAN_OR_EQUAL,"6")
        "irrelevant"| "gt(6)" || new Pair<CriteriaOperator,String>(CriteriaOperator.GREATER_THAN,"6")
        "irrelevant"| "lt(5)" || new Pair<CriteriaOperator,String>(CriteriaOperator.LESS_THAN,"5")
        "irrelevant"| "lte(foo)" || new Pair<CriteriaOperator,String>(CriteriaOperator.LESS_THAN_OR_EQUAL,"foo")
        "irrelevant"| "f*oo"     || new Pair<CriteriaOperator,String>(CriteriaOperator.LIKE,"f*oo")
        "relevant!" | "foo" || new Pair<CriteriaOperator,String>(CriteriaOperator.NOT_EQUAL,"foo")
        "irrelevant"| "   f*oo   "     || new Pair<CriteriaOperator,String>(CriteriaOperator.LIKE,"f*oo")

    }

    def "Test when a key has operator like #input it is properly stripped" () {
        expect:
        UriParameterOperationAdapter.removeKeyOperators(input)

        where:
        input   || output
        "test!" || "test"
    }
}
