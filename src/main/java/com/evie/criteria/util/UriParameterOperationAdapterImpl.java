package com.evie.criteria.util;

import com.evie.criteria.util.enumueration.CriteriaOperator;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import static com.evie.criteria.util.enumueration.CriteriaOperator.*;

/**
 * Created by rmhedge on 8/1/17.
 */
@Component
public class UriParameterOperationAdapterImpl implements UriParameterOperationAdapter {

    /**
     * Mimics a query language in REST which allows for complicated queries using URI params which
     * are represented by a multivalue map
     *
     * @param mapKey
     * @param value
     * @return
     */
    public Pair<CriteriaOperator, String> parseFromUriValue(String mapKey, String value) {
        String key = mapKey.trim();
        String input = value.trim();
        if (input.endsWith(")")) {
            input = input.substring(0, input.length() - 1);
        }
        if (input.contains("gte(") && key.contains("!")) {
            return new Pair<>(LESS_THAN, removeValueOperators(input));
        } else if (input.startsWith("gt(") && key.contains("!")){
            return new Pair<>(LESS_THAN_OR_EQUAL, removeValueOperators(input));
        } else if (input.startsWith("lte(") && key.contains("!")){
            return new Pair<>(GREATER_THAN, removeValueOperators(input));
        } else if (input.startsWith("lt(") && key.contains("!")) {
            return new Pair<>(GREATER_THAN_OR_EQUAL, input);
        } else if (key.endsWith("!") && input.contains("**")) {
            return new Pair<>(NOT_LIKE_IGNORE_CASE, input);
        } else if (key.endsWith("!") && input.contains("*")) {
            return new Pair<>(NOT_LIKE, input);
        } else if (key.endsWith("!")) {
            return new Pair<>(NOT_EQUAL, input);
        } else if (input.contains("**")) {
            return new Pair<>(LIKE_IGNORE_CASE, input);
        } else if (input.contains("*")) {
            return new Pair<>(LIKE, input);
        } else if (input.contains("gte(")) {
            return new Pair<>(GREATER_THAN_OR_EQUAL, removeValueOperators(input));
        } else if (input.startsWith("gt(")) {
            return new Pair<>(GREATER_THAN, removeValueOperators(input));
        } else if (input.startsWith("lte(")) {
            return new Pair<>(LESS_THAN_OR_EQUAL, removeValueOperators(input));
        } else if (input.startsWith("lt(")) {
            return new Pair<>(LESS_THAN, removeValueOperators(input));
        } else {
            return new Pair<>(EQUAL, input);
        }
    }

    /**
     * Sometimes it is convenient to have operators appear in the keys to mimic programming conventions
     * We need to String them out in order to make sure we don't change the key
     *
     * @param input
     * @return
     */
    public String removeKeyOperators(String input) {
        return input.replaceAll("!", "");
    }

    /**
     * We don't use operators other than * which is needed to be replaced withe regexes later.
     * This does nothing.
     *
     * @param value
     * @return
     */
    public String removeValueOperators(String value) {
        return value.replaceAll("^[a-z]+\\(|\\)$","");
    }



}
