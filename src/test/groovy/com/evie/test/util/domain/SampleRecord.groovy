package com.evie.test.util.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="sample_records")
class SampleRecord {

    String stage;
    Date eventTime;
    List<SampleSubRecord> subRecords;

}
