package com.evie.criteria.util;

import com.evie.criteria.util.enumueration.BooleanOperation;
import com.evie.criteria.util.enumueration.CriteriaOperator;
import com.evie.criteria.util.enumueration.MongoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by rmhedge on 8/4/17.
 */
@Service
public class CriteriaUtil {

    private static Logger log = LoggerFactory.getLogger(CriteriaUtil.class);

    public Criteria generateCriteriaFromMap(String key, MultiValueMap<CriteriaOperator, String> paramMap, BooleanOperation operation) {
        MongoType mongoType = UriParameterUtil.treatAs(paramMap);
        List<Criteria> allCriteria = new ArrayList<>();

        if(paramMap.get(CriteriaOperator.EQUAL)!=null) {
            allCriteria.add(equalCriteria(key,paramMap.get(CriteriaOperator.EQUAL),mongoType));
        }
        if(paramMap.get(CriteriaOperator.NOT_EQUAL)!=null) {
            allCriteria.add(notEqualCriteria(key,paramMap.get(CriteriaOperator.NOT_EQUAL),mongoType));
        }
        if(paramMap.get(CriteriaOperator.GREATER_THAN)!=null) {
            allCriteria.add(greaterThanCriteria(key,paramMap.get(CriteriaOperator.GREATER_THAN),mongoType));
        }
        if(paramMap.get(CriteriaOperator.GREATER_THAN_OR_EQUAL)!=null) {
            allCriteria.add(greaterThanOrEqualCriteria(key,paramMap.get(CriteriaOperator.GREATER_THAN_OR_EQUAL),mongoType));
        }
        if(paramMap.get(CriteriaOperator.LESS_THAN)!=null) {
            allCriteria.add(lessThanCriteria(key,paramMap.get(CriteriaOperator.LESS_THAN),mongoType));
        }
        if(paramMap.get(CriteriaOperator.LESS_THAN_OR_EQUAL)!=null) {
            allCriteria.add(lessThanOrEqualCriteria(key,paramMap.get(CriteriaOperator.LESS_THAN_OR_EQUAL),mongoType));
        }
        if(paramMap.get(CriteriaOperator.LIKE)!=null) {
            allCriteria.add(likeCriteria(key,paramMap.get(CriteriaOperator.LIKE),mongoType,false));
        }
        if(paramMap.get(CriteriaOperator.LIKE_IGNORE_CASE)!=null) {
            allCriteria.add(likeCriteria(key,paramMap.get(CriteriaOperator.LIKE_IGNORE_CASE),mongoType,true));
        }
        if(paramMap.get(CriteriaOperator.NOT_LIKE)!=null) {
            allCriteria.add(notLikeCriteria(key,paramMap.get(CriteriaOperator.NOT_LIKE),mongoType,false));
        }
        if(paramMap.get(CriteriaOperator.NOT_LIKE_IGNORE_CASE)!=null) {
            allCriteria.add(notLikeCriteria(key,paramMap.get(CriteriaOperator.NOT_LIKE_IGNORE_CASE),mongoType,true));
        }
        if(allCriteria.size()==0) {
            return new Criteria();
        }
        else if(allCriteria.size()==1) {
            return allCriteria.get(0);
        }
        else if(operation==BooleanOperation.OR) {
            return new Criteria().orOperator(allCriteria.toArray(new Criteria[allCriteria.size()]));
        }
        else {
            return new Criteria().andOperator(allCriteria.toArray(new Criteria[allCriteria.size()]));
        }
    }

    public Criteria greaterThanCriteria(String key, List<String> stringValues, MongoType mongoType) {
        List<Comparable> objects = convertStringsToType(mongoType, stringValues);
        if (objects.size() == 1) {
            return Criteria.where(key).gt(objects.get(0));
        } else if (objects.size() > 1) {
            log.info("User requested multiple greater than values defaulting to the largest");
            return Criteria.where(key).gt(findGreatest(objects));
        } else return new Criteria();
    }
    public Criteria greaterThanOrEqualCriteria(String key, List<String> stringValues, MongoType mongoType) {
        List<Comparable> objects = convertStringsToType(mongoType, stringValues);
        if (objects.size() == 1) {
            return Criteria.where(key).gte(objects.get(0));
        } else if (objects.size() > 1) {
            log.info("User requested multiple greateror equal to than values defaulting to the largest");
            return Criteria.where(key).gte(findGreatest(objects));
        } else return new Criteria();
    }

    public Criteria lessThanOrEqualCriteria(String key, List<String> stringValues, MongoType mongoType) {
        List<Comparable> objects = convertStringsToType(mongoType, stringValues);
        if (objects.size() == 1) {
            return Criteria.where(key).lte(objects.get(0));
        } else if (objects.size() > 1) {
            log.info("User requested multiple less than  or equal to values defaulting to the smallest");
            return Criteria.where(key).lte(findSmallest(objects));
        } else return new Criteria();
    }

    public Criteria lessThanCriteria(String key, List<String> stringValues, MongoType mongoType) {
        List<Comparable> objects = convertStringsToType(mongoType, stringValues);
        if (objects.size() == 1) {
            return Criteria.where(key).lt(objects.get(0));
        } else if (objects.size() > 1) {
            log.info("User requested multiple less than values defaulting to the smallest");
            return Criteria.where(key).lt(findSmallest(objects));
        } else return new Criteria();
    }


    protected static Comparable findGreatest(List<Comparable> objList) {
        Comparable greatest = null;
        for (Comparable o : objList) {
            if (greatest == null) {
                greatest = o;
            }
            if(o.compareTo(greatest)>0) {
                greatest = o;
            }
        }
        return greatest;
    }

    protected static Comparable findSmallest(List<Comparable> objList) {
        Comparable smallest = null;
        for (Comparable o : objList) {
            if (smallest == null) {
                smallest = o;
            }
            if(o.compareTo(smallest)<0) {
                smallest = o;
            }
        }
        return smallest;
    }



    public Criteria equalCriteria(String key, List<String> stringValues, MongoType mongoType) {
        List<Comparable> objects = convertStringsToType(mongoType, stringValues);
        if (objects.size() == 1) {
            return Criteria.where(key).is(objects.get(0));
        } else if (objects.size() > 1) {
            return Criteria.where(key).in(objects);
        } else return new Criteria();
    }

    public Criteria notEqualCriteria(String key, List<String> stringValues, MongoType mongoType) {
        List<Comparable> objects = convertStringsToType(mongoType, stringValues);
        if (objects.size() == 1) {
            return Criteria.where(key).ne(objects.get(0));
        } else if (objects.size() > 1) {
            return Criteria.where(key).nin(objects);
        } else return new Criteria();
    }

    public Criteria likeCriteria(String key, List<String> likeValues, MongoType mongoType,boolean ignoreCase) {
        if(!mongoType.equals(MongoType.STRING)) {
            throw new IllegalArgumentException("Unable to perform a like on a non-text value");
        }
        List<Criteria> allLikeCriteria = new ArrayList<>();
        for (String wildCardedVal : likeValues) {
            Pattern p = WildCardToRegexUtil.buildPatternFromWildCardedString(wildCardedVal,ignoreCase);
            allLikeCriteria.add(Criteria.where(key).regex(p));
        }
        //TODO I'd really prefer that this was an '$in' query for performance reasons
        return new Criteria().orOperator(allLikeCriteria.toArray(new Criteria[allLikeCriteria.size()]));
    }

    public Criteria notLikeCriteria(String key, List<String> notLikeValues, MongoType mongoType,boolean ignoreCase) {
        if(!mongoType.equals(MongoType.STRING)) {
            throw new IllegalArgumentException("Unable to perform a like on a non-text value");
        }
        List<Criteria> allNotLikeCriteria = new ArrayList<>();
        for (String wildCardedVal : notLikeValues) {
            Pattern p = WildCardToRegexUtil.buildPatternFromWildCardedString(wildCardedVal,ignoreCase);
            allNotLikeCriteria.add(Criteria.where(key).not().regex(p));
        }
        //TODO I'd really prefer that this was a '$nin' query for performance reasons
        return new Criteria().andOperator(allNotLikeCriteria.toArray(new Criteria[allNotLikeCriteria.size()]));
    }

    private List<Comparable> convertStringsToType(MongoType type, List<String> values) {
        List<Comparable> retVal = new ArrayList<>();
        for (String val : values) {
            switch (type) {
                case STRING:
                    retVal.add(val);
                    break;
                case INTEGER:
                    retVal.add(Integer.parseInt(val));
                    break;
                case DOUBLE:
                    retVal.add(Double.parseDouble(val));
                    break;
            }
        }
        return retVal;
    }


}
