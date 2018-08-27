package com.evie.test.util.configuration;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.context.annotation.Configuration() @org.springframework.boot.autoconfigure.AutoConfigureBefore(value=com.evie.configuration.MongoClientConfiguration.class) public class FlapdoodleMongoConfiguration
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
@org.springframework.context.annotation.Bean() public  cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean embeddedMongoFactoryBean() { return (cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean)null;}
@org.springframework.context.annotation.Bean() public  com.mongodb.MongoClient mongoClient(cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean mongo) { return (com.mongodb.MongoClient)null;}
@org.springframework.context.annotation.Bean() public  org.springframework.data.mongodb.core.MongoTemplate mongoTemplate(com.mongodb.MongoClient mongoClient)throws java.io.IOException { return (org.springframework.data.mongodb.core.MongoTemplate)null;}
}
