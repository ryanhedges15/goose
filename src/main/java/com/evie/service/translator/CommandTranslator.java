package com.evie.service.translator;

import com.evie.domain.MongoShellCommandWrapper;
import com.mongodb.BasicDBObject;

import java.util.Arrays;
import java.util.Base64;

/**
 * Created by rmhedge on 7/28/17.
 */
public interface  CommandTranslator {

    BasicDBObject convertToBasicDBObject(MongoShellCommandWrapper commandWrapper);

    boolean matches(MongoShellCommandWrapper commandWrapper);

}

