package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.exception.LeagueNotFoundException;
import com.webdb.footballagent.footballagent.model.League;
import com.webdb.footballagent.footballagent.model.Team;
import com.webdb.footballagent.footballagent.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "league_by_name/{league_name}")
    public ResponseEntity<League>getLeagueName(@PathVariable("league_name") String league_name)  {
        try {
            return new ResponseEntity<>(leagueService.getLeagueByName(league_name), HttpStatus.OK);
        } catch (LeagueNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
