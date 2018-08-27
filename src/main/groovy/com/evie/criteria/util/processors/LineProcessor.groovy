package com.evie.criteria.util.processors

import com.evie.criteria.util.domain.MonitoringRecord

/**
 * Created by rmhedge on 4/9/16.
 */
interface LineProcessor {
    MonitoringRecord processLine(String line);
}
