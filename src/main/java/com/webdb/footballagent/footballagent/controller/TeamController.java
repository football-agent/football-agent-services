package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.exception.TeamNotFoundException;
import com.webdb.footballagent.footballagent.model.Player;
import com.webdb.footballagent.footballagent.model.Stat;
import com.webdb.footballagent.footballagent.model.Team;
import com.webdb.footballagent.footballagent.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/football_agent")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(value = "all_teams")
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping(value = "all_players")
    public List<Player> getPlayers(){
        return teamService.getAllPlayers();
    }

    @GetMapping(value ="player_by_name/{player_name}")
    public Player getPlayerByName(@PathVariable String player_name){
        return teamService.getPlayerByName(player_name);
    }

    @GetMapping(value ="stats_by_team/{team_name}")
    public List<Stat> getStatsByTeam(@PathVariable String team_name){
        return teamService.getStatsByTeam(team_name);
    }



//    @GetMapping(value = "team_by_name/{team_name}")
//    public ResponseEntity<Team> getTeamByName(@PathVariable("team_name") String team_name) {
//        try {
//            return new ResponseEntity<>(teamService.getTeamByName(team_name), HttpStatus.OK);
//        } catch (TeamNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        }
//    }
}
