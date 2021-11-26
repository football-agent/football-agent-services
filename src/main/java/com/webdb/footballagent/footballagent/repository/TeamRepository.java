package com.webdb.footballagent.footballagent.repository;

import com.webdb.footballagent.footballagent.model.team.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, Integer> {
}
