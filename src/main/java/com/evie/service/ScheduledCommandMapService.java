package com.evie.service;

import com.evie.configuration.ScheduledJobProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmhedge on 4/23/17.
 */
@Service
public class ScheduledCommandMapService {

    public static Logger logger = LoggerFactory.getLogger(ScheduledCommandMapService.class);

    @Autowired
    ScheduledJobProperties scheduledJobProperties;

    private Map<String,String> keyToCronMap =  new HashMap<>();

    @PostConstruct
    public void init() {
        for(String key: scheduledJobProperties.getSchedule().keySet()) {
            logger.info(key);
        }
    }


}
