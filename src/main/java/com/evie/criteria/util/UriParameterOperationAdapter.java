package com.evie.criteria.util;

import com.evie.criteria.util.enumueration.CriteriaOperator;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

/** Class is intended to provide a simple bride between a developers URI parameter scheme and
 * the Criteria logic code.
 * Created by rmhedge on 8/6/17.
 */
public interface UriParameterOperationAdapter {
    /**
     * Maps keys and values to query operations
     * @param mapKey
     * @param value
     * @return
     */
     Pair<CriteriaOperator,String> parseFromUriValue(String mapKey, String value);

    /**
     * Removes api specific language from the keys of your URi. For example I prefer using
     * != for not equal that results in a ! being appended to the URI key(foo!=bar results in
     * foo! being the key rather than foo)
     * @param key
     * @return
     */
     String removeKeyOperators(String key);

    /**
     * Removes any operator items from the value portion of a URI param
     * @param value
     * @return
     */
     String removeValueOperators(String value);


}

