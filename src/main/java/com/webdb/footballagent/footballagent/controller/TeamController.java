package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.service.TeamService;
import org.springframework.stereotype.Controller;

@Controller
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
}
