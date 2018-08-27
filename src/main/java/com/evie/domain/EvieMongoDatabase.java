package com.evie.domain;

import groovy.transform.EqualsAndHashCode;

import java.util.List;

/**
 * Created by rmhedge on 3/18/17.
 */
@EqualsAndHashCode
public class EvieMongoDatabase {

    private String databaseName;
    private int databaseSizeInBytes;
    private boolean empty;
    private List<EvieMongoCollection> mongoCollections;
    private String version;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public int getDatabaseSizeInBytes() {
        return databaseSizeInBytes;
    }

    public void setDatabaseSizeInBytes(int databaseSizeInBytes) {
        this.databaseSizeInBytes = databaseSizeInBytes;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public List<EvieMongoCollection> getMongoCollections() {
        return mongoCollections;
    }

    public void setMongoCollections(List<EvieMongoCollection> mongoCollections) {
        this.mongoCollections = mongoCollections;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
