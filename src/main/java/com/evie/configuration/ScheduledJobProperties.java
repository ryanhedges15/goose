package com.evie.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmhedge on 4/23/17.
 */
@Component
@ConfigurationProperties("evie.automated")
public class ScheduledJobProperties {

    Map<String,String> schedule = new HashMap<>();

    String defaultSchedule;

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public String getDefaultSchedule() {
        return defaultSchedule;
    }

    public void setDefaultSchedule(String defaultSchedule) {
        this.defaultSchedule = defaultSchedule;
    }
}
