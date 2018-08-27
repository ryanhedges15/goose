package com.evie.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by shannonhedges on 8/6/17.
 */
@Document(collection = "collStats")
public class CollectionStats {
    private int totalIndexSize;
    private int size;
    private int avgObjSize;
    private int storageSize;

    public int getTotalIndexSize() {
        return totalIndexSize;
    }

    public void setTotalIndexSize(int totalIndexSize) {
        this.totalIndexSize = totalIndexSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAvgObjSize() {
        return avgObjSize;
    }

    public void setAvgObjSize(int avgObjSize) {
        this.avgObjSize = avgObjSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }
}
