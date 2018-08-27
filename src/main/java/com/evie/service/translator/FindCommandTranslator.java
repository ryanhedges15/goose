package com.evie.service.translator;

import com.evie.domain.MongoShellCommandWrapper;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by rmhedge on 7/28/17.
 */
public class FindCommandTranslator implements CommandTranslator {

    @Override
    public BasicDBObject convertToBasicDBObject(MongoShellCommandWrapper commandWrapper) {
        return null;
    }

    @Override
    public boolean matches(MongoShellCommandWrapper commandWrapper) {
        commandWrapper.getCommand();
        return false;
    }
}
