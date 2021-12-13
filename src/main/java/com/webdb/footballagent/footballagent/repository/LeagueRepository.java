package com.webdb.footballagent.footballagent.repository;

import com.webdb.footballagent.footballagent.model.League;
import com.webdb.footballagent.footballagent.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LeagueRepository extends MongoRepository<League, String> {
    public Optional<League> findByLeagueName(String name);

}
