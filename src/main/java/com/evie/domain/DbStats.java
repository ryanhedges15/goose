package com.evie.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by rmhedge on 7/29/17
 * Tends to be derived from
 *  Document{{db=admin, collections=1, views=0, objects=1, avgObjSize=59.0, dataSize=59.0, storageSize=16384.0, numExtents=0, indexes=2, indexSize=32768.0, ok=1.0}}
 .
 */
@Document(collection = "dbStats")
public class DbStats {

    private String databaseName;
    private Date queryTime;
    private double sizeInBytes;
    private double storageSize;
    private double indexSizeInBytes;
    private int numCollections;
    private double averageObjectSize;
    private int numIndexes;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public double getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(double sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public double getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(double storageSize) {
        this.storageSize = storageSize;
    }

    public double getIndexSizeInBytes() {
        return indexSizeInBytes;
    }

    public void setIndexSizeInBytes(double indexSizeInBytes) {
        this.indexSizeInBytes = indexSizeInBytes;
    }

    public int getNumCollections() {
        return numCollections;
    }

    public void setNumCollections(int numCollections) {
        this.numCollections = numCollections;
    }

    public double getAverageObjectSize() {
        return averageObjectSize;
    }

    public void setAverageObjectSize(double averageObjectSize) {
        this.averageObjectSize = averageObjectSize;
    }

    public int getNumIndexes() {
        return numIndexes;
    }

    public void setNumIndexes(int numIndexes) {
        this.numIndexes = numIndexes;
    }
}
