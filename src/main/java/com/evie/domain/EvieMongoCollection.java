package com.evie.domain;

public class EvieMongoCollection {
    private String namespace;
    private String collectonName;
    private String collectionSize;
    private String collectionCount;

    private boolean sharded;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getCollectonName() {
        return collectonName;
    }

    public void setCollectonName(String collectonName) {
        this.collectonName = collectonName;
    }

    public String getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(String collectionSize) {
        this.collectionSize = collectionSize;
    }

    public String getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(String collectionCount) {
        this.collectionCount = collectionCount;
    }

    public boolean isSharded() {
        return sharded;
    }

    public void setSharded(boolean sharded) {
        this.sharded = sharded;
    }
}
