package com.evie.criteria.util.controller;

import com.evie.criteria.util.CriteriaUtil;
import com.evie.criteria.util.UriParameterUtil;
import com.evie.criteria.util.enumueration.BooleanOperation;
import com.evie.criteria.util.enumueration.CriteriaOperator;
import com.evie.repository.MongoMetricsRespository;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rmhedge on 8/8/17.
 */
@Api("Generic document filter")
@RestController
@RequestMapping("/api/metrics")
public class GenericDocumentController {

    private Logger log = LoggerFactory.getLogger(GenericDocumentController.class);
    @Autowired
    MongoMetricsRespository mongoMetricsRespository;

    @Autowired
    UriParameterUtil uriParameterUtil;

    @Autowired
    CriteriaUtil criteriaUtil;

    @ApiOperation(value = "Document Filter Controller")
    @RequestMapping(value = "/{collection}", method = RequestMethod.GET, produces="application/json")
    public List<DBObject> find(@PathVariable("collection") String collection, @RequestParam(required = false) MultiValueMap<String,String> parameters) {
        Map<String, MultiValueMap<CriteriaOperator, String>> sortedMap = uriParameterUtil.normalizeQueryParameters(parameters);
        Criteria criteria = new Criteria();
        List<Criteria> critList = new ArrayList<>();
        for(String key:sortedMap.keySet()) {
            critList.add(criteriaUtil.generateCriteriaFromMap(key,sortedMap.get(key), BooleanOperation.OR));
        }

        if(critList.size()==0) {
            criteria = new Criteria();
        }
        else if(critList.size()==1) {
            criteria = critList.get(0);
        }
        else {
            criteria.andOperator(critList.toArray(new Criteria[critList.size()]));
        }

        log.info("Generated Criteria was:\n" + new Query(criteria).toString());

        List<DBObject> docs = mongoMetricsRespository.findByCriteria(collection,criteria);
        List<String> jsonStrings = new ArrayList<>();

        for(DBObject doc : docs) {
            jsonStrings.add(JSON.serialize(doc));
        }
        return docs;
    }

}
