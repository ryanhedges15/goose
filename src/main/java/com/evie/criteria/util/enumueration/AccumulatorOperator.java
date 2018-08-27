package com.evie.criteria.util.enumueration;

/**
 * Created by rmhedge on 7/30/17.
 */
public enum AccumulatorOperator {
    SUM, AVG, MAX, MIN;


public static String valueOf(AccumulatorOperator operator) {
        switch (operator) {
            case SUM:
                return "$sum";
            case AVG:
                return "$avg";
            case MAX:
                return "$max";
            case MIN:
                return "$min";
        }
        return "undefined";
    }
}