package com.webdb.footballagent.footballagent.service;

import com.webdb.footballagent.footballagent.repository.TeamRepository;

public class TeamService {


    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
