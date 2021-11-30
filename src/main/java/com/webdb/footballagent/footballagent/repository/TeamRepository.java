package com.webdb.footballagent.footballagent.repository;

import com.webdb.footballagent.footballagent.model.team.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamRepository extends MongoRepository<Team, String> {
    public Optional<Team> findByTeam(String name);
}
