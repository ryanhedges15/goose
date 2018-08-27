package com.evie.criteria.util.domain;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

public class MongostatRecord
  extends com.evie.criteria.util.domain.MonitoringRecord {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  java.lang.String getHost() { return (java.lang.String)null;}
public  void setHost(java.lang.String host) { }
public  int getNum() { return (int)0;}
public  void setNum(int num) { }
public  int getNumberInserts() { return (int)0;}
public  void setNumberInserts(int numberInserts) { }
public  int getNumberQueries() { return (int)0;}
public  void setNumberQueries(int numberQueries) { }
public  int getNumberUpdates() { return (int)0;}
public  void setNumberUpdates(int numberUpdates) { }
public  int getNumberDeletes() { return (int)0;}
public  void setNumberDeletes(int numberDeletes) { }
public  int getNumberGetmore() { return (int)0;}
public  void setNumberGetmore(int numberGetmore) { }
public  int getNumberCommands() { return (int)0;}
public  void setNumberCommands(int numberCommands) { }
public  int getNumberFlushes() { return (int)0;}
public  void setNumberFlushes(int numberFlushes) { }
public  double getPercentageDirty() { return (double)0;}
public  void setPercentageDirty(double percentageDirty) { }
public  double getPercentageCacheInUse() { return (double)0;}
public  void setPercentageCacheInUse(double percentageCacheInUse) { }
public  int getVirtualMemorySize() { return (int)0;}
public  void setVirtualMemorySize(int virtualMemorySize) { }
public  double getResidentMegabytes() { return (double)0;}
public  void setResidentMegabytes(double residentMegabytes) { }
public  int getQueuedReads() { return (int)0;}
public  void setQueuedReads(int queuedReads) { }
public  int getQueuedWrires() { return (int)0;}
public  void setQueuedWrires(int queuedWrires) { }
public  int getActiveClientsReading() { return (int)0;}
public  void setActiveClientsReading(int activeClientsReading) { }
public  int getActiveClientsWriting() { return (int)0;}
public  void setActiveClientsWriting(int activeClientsWriting) { }
public  int getNetworkTrafficIn() { return (int)0;}
public  void setNetworkTrafficIn(int networkTrafficIn) { }
public  int getNetworkTrafficOut() { return (int)0;}
public  void setNetworkTrafficOut(int networkTrafficOut) { }
public  int getNumberConnections() { return (int)0;}
public  void setNumberConnections(int numberConnections) { }
public  java.lang.String getReplicaSetName() { return (java.lang.String)null;}
public  void setReplicaSetName(java.lang.String replicaSetName) { }
public  com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus getReplicationStaus() { return (com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus)null;}
public  java.util.List<java.lang.String> getFieldsWithAsterisk() { return (java.util.List<java.lang.String>)null;}
public  void setFieldsWithAsterisk(java.util.List<java.lang.String> fieldsWithAsterisk) { }
public  int getNumberLocalCommands() { return (int)0;}
public  void setNumberLocalCommands(int numberLocalCommands) { }
public  int getQueuedWrites() { return (int)0;}
public  void setQueuedWrites(int queuedWrites) { }
public  void setReplicationStaus(com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus replicationStaus) { }
public  int getNumberReplicatedCommands() { return (int)0;}
public  void setNumberReplicatedCommands(int numberReplicatedCommands) { }
public enum ReplicationStatus
  implements
    groovy.lang.GroovyObject {
PRIMARY, SECONDARY, RECOVERING, UNKNOWN, ROUTER, ARBITER;
public static final com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus MIN_VALUE = null;
public static final com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus MAX_VALUE = null;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus next() { return (com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus)null;}
public  com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus previous() { return (com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus)null;}
public static final  com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus $INIT(java.lang.Object... para) { return (com.evie.criteria.util.domain.MongostatRecord.ReplicationStatus)null;}
}
}
