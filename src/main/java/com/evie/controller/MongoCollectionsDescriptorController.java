package com.evie.controller;

import com.evie.domain.EvieMongoCollection;
import com.evie.service.CollectionMetadataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Describes the database and collections of the cluster.

@Api("Mongo Collections Descriptions")
@RestController
@RequestMapping("/api/database")
public class MongoCollectionsDescriptorController {

    @Autowired
    CollectionMetadataService collectionMetadataService;

    @ApiOperation(value = "describe", nickname = "Describes all collections and databases")
    @RequestMapping(value = "/collections", method = RequestMethod.GET)
    public List<EvieMongoCollection> findCollectionsByDatabase(@RequestParam("databaseName") String name) {
        return collectionMetadataService.findCollectionsByDatabaseName(name);
    }
}
