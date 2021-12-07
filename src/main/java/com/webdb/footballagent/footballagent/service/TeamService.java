package com.webdb.footballagent.footballagent.service;

import com.webdb.footballagent.footballagent.exception.TeamNotFoundException;
import com.webdb.footballagent.footballagent.model.team.Player;
import com.webdb.footballagent.footballagent.model.team.Team;
import com.webdb.footballagent.footballagent.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {


    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamByName(String name) throws TeamNotFoundException {
        return teamRepository.findByTeam(name).orElseThrow(() -> new TeamNotFoundException("The team with this name does not exist"));
    }

    public List<Player> getAllPlayers() {
        List<Player> players = teamRepository.findAll().stream().map(Team::getPlayers).collect(Collectors.toList()).stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return players;

    }
}
