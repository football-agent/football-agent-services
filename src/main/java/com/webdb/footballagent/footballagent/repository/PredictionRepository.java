package com.webdb.footballagent.footballagent.repository;

import com.webdb.footballagent.footballagent.model.PredictionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PredictionRepository extends MongoRepository<PredictionModel, String> {
}
