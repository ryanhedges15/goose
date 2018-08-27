package com.evie.controller;

import com.evie.domain.EvieMongoDatabase;
import com.evie.service.MongoDatabaseDescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**Describes the database and collections of the cluster
 * Created by rmhedge on 3/18/17.
 */
@Api
@RestController
@RequestMapping("/api/database/")
public class MongoDatabaseDescriptorController {

    private static final Logger log = LoggerFactory.getLogger(MongoDatabaseDescriptorController.class);

    @Autowired
    MongoDatabaseDescriptionService mongoDatabaseDescriptionService;

    @ApiOperation(value = "describe", nickname = "Describes all collections and databases")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<EvieMongoDatabase> showDatabases() {
        log.debug("User has made a request to show all databases");
        return mongoDatabaseDescriptionService.retrieveAllDatabasses();
    }


}
