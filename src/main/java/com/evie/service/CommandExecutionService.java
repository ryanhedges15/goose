package com.evie.service;

import com.evie.domain.MongoShellCommandWrapper;
import com.evie.service.translator.CommandTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rmhedge on 7/28/17.
 */
@Service
public class CommandExecutionService {

    //@Autowired
    private List<CommandTranslator> commandTranslatorList;

    public String executeCommand(MongoShellCommandWrapper commandWrapper) {
        return "";
    }

}
