package com.evie.service;

import com.evie.domain.EvieMongoDatabase;
import com.evie.repository.MongoDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rmhedge on 4/2/17.
 */
@Service
public class MongoDatabaseDescriptionService {

    @Autowired
    private MongoDatabaseRepository mongoDatabaseRepository;

    public List<EvieMongoDatabase> retrieveAllDatabasses() {
        return mongoDatabaseRepository.findAllDatabases();

    }


}
