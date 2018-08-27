package com.evie.criteria.util;

import com.evie.criteria.util.enumueration.CriteriaOperator;
import com.evie.criteria.util.enumueration.MongoType;
import javafx.util.Pair;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

/**
 * Created by rmhedge on 7/31/17.
 */
@Component
public class UriParameterUtil {


    @Autowired
    UriParameterOperationAdapter uriParameterOperationAdapter;

    /**
     * Generates Criteria where each key is anded together but multiple values are OR'd together. This is useful
     * for web requests
     *
     * @param multiValueMap
     * @return
     */
    public Map<String, MultiValueMap<CriteriaOperator, String>> normalizeQueryParameters(MultiValueMap<String, String> multiValueMap) {
        Map<String, MultiValueMap<CriteriaOperator, String>> allKeys = new HashMap<>();

        /*First we'll go over each parameter and identify the type of operation that will be done
         We'll organize the query into operations by key so we can support queries that use more than one
         operation on the same key*/

        for (String key : multiValueMap.keySet()) {
            List<String> objects = multiValueMap.get(key);
            MultiValueMap<CriteriaOperator, String> similarOperations = new LinkedMultiValueMap<>();
            for (String val : objects) {
                Pair<CriteriaOperator, String> operation = uriParameterOperationAdapter.parseFromUriValue(key, val);
                similarOperations.add(operation.getKey(), operation.getValue());
            }
            allKeys.put(uriParameterOperationAdapter.removeKeyOperators(key),similarOperations);

        }
        return allKeys;
    }

    /**
     * While Mongo supports putting values of differing types in the same keys
     * we will not. We will make the assumption that if all variables are numbers then
     * the values will be used in queries as numeric types. If a single value for a key is a String
     * all values wil be treated as Strings.
     * @param operationVariables
     */
    protected static MongoType treatAs(MultiValueMap<CriteriaOperator,String> operationVariables) {
        Set<MongoType> calculatedTypes = new HashSet<>();
        for(CriteriaOperator key:operationVariables.keySet()) {
            for(String var: operationVariables.get(key)) {
                MongoType type = guessType(var);
                if(type==MongoType.STRING) {
                    return MongoType.STRING;
                }
                calculatedTypes.add(type);
            }
        }
        if(calculatedTypes.contains(MongoType.DOUBLE)) {
            return MongoType.DOUBLE;
        }
        else {
            return MongoType.INTEGER;
        }
    }

    protected static MongoType guessType(String input) {
        if (NumberUtils.isCreatable(input)) {
            if (input.contains(".")) {
                return MongoType.DOUBLE;
            } else return MongoType.INTEGER;
        }
        //TODO check to see if the field is a valid date
        return MongoType.STRING;
    }

    /**
     * Certain operations like regex should only be supported by text values
     *
     * @return
     */
    public boolean isText(List<String> values) {
        for (String val : values) {
            if (!NumberUtils.isCreatable(val)) {
                //If there is any case where this is a String we will always treat the key as a String
                return true;
            }
        }
        return false;
    }
}
