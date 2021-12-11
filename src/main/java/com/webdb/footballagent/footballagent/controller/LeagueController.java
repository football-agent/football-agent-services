package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.model.League;
import com.webdb.footballagent.footballagent.model.Team;
import com.webdb.footballagent.footballagent.service.LeagueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/football_agent")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping(value = "all_leagues")
    public List<League> getLeagues() {
        return leagueService.getAllLeagues();
    }

}
