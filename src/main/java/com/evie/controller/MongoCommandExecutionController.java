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

@Api("Command API")
@RestController
@RequestMapping("/api/mongo/commands")
public class MongoCommandExecutionController {

    private static final Logger log = LoggerFactory.getLogger(MongoCommandExecutionController.class);

    @ApiOperation(value = "command", nickname = "")
    @RequestMapping(value = "database/{databaseName}/command", method = RequestMethod.GET)
    public String getResultForCommand() {
        log.debug("User has made a request to show all databases");
        return null;
    }


}
