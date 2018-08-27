package com.evie.criteria.util;

import java.util.List;
import java.util.regex.Pattern;

/** Class generates a single regular expression per call
 * Created by rmhedge on 8/5/17.
 */
public class WildCardToRegexUtil {

    public static Pattern buildPatternFromWildCardedStrings(List<String> wildcardedStrings,boolean ignoreCase) {
        StringBuffer patternString = new StringBuffer();
        for(String wildCardedString:wildcardedStrings) {
            patternString.append(buildStringPatternFromWildCardedString(wildCardedString));
            patternString.append("|");
        }
        patternString.replace(patternString.length()-1,patternString.length(),"");
        if(ignoreCase) {
            return Pattern.compile(patternString.toString(),Pattern.CASE_INSENSITIVE);
        }
        return Pattern.compile(patternString.toString());
    }

    public static Pattern buildPatternFromWildCardedString(String wildCardedString,boolean ignoreCase) {
        if(ignoreCase) {
            return Pattern.compile(buildStringPatternFromWildCardedString(wildCardedString),Pattern.CASE_INSENSITIVE);
        }
        return Pattern.compile(buildStringPatternFromWildCardedString(wildCardedString));
    }

    private static String buildStringPatternFromWildCardedString(String wildCardedString) {
        StringBuffer pattern = new StringBuffer();
        if(wildCardedString.charAt(0)!='*') {
            pattern.append("^");
        }
        String regex = wildCardedString.replace("*",".*");
        pattern.append(regex);
        if(pattern.charAt(pattern.length()-1)!='*') {
            pattern.append("$");
        }
        return pattern.toString();
    }
}
