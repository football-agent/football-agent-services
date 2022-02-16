package com.webdb.footballagent.footballagent.service;

import com.webdb.footballagent.footballagent.exception.TeamNotFoundException;
import com.webdb.footballagent.footballagent.model.League;
import com.webdb.footballagent.footballagent.model.Player;
import com.webdb.footballagent.footballagent.model.Stat;
import com.webdb.footballagent.footballagent.model.Team;
import com.webdb.footballagent.footballagent.repository.LeagueRepository;
import com.webdb.footballagent.footballagent.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {


    private final LeagueRepository leagueRepository;

    public TeamService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }


    public List<Team> getAllTeams() {
        List<Team> teams = leagueRepository.findAll().stream().map(League::getTeams).collect(Collectors.toList()).stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return teams;
    }

    public List<Player> getAllPlayers() {
        List<Player> players = getAllTeams().stream().map(Team::getPlayers).collect(Collectors.toList()).stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return players;

    }

    public Player getPlayerByName(String playerName){
        return getAllPlayers().stream().filter(player->player.getPlayer().equals(playerName)).collect(Collectors.toList()).get(0);
    }

    public List<Stat> getStatsByTeam(String team_name) {
        return getAllTeams().stream().filter(team -> team.getTeam().equals(team_name)).findFirst().get().getStats();
    }
}
