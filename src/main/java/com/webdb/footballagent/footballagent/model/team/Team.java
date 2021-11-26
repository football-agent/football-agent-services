package com.webdb.footballagent.footballagent.model.team;


import com.webdb.footballagent.footballagent.model.player.Player;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
public class Team {
    private Integer team_id;
    private String name;
    private  String code;
    private Titles titles;
    private Map<String, LeagueRank> league_rank;
    private Integer stadium_size;
    private Integer avg_attendence;
    private List<Integer> arrivals;
    private List<Integer> departures;
    private String instagram_followers;
    private List<Player> players;

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Titles getTitles() {
        return titles;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    public Map<String, LeagueRank> getLeague_rank() {
        return league_rank;
    }

    public void setLeague_rank(Map<String, LeagueRank> league_rank) {
        this.league_rank = league_rank;
    }

    public Integer getStadium_size() {
        return stadium_size;
    }

    public void setStadium_size(Integer stadium_size) {
        this.stadium_size = stadium_size;
    }

    public Integer getAvg_attendence() {
        return avg_attendence;
    }

    public void setAvg_attendence(Integer avg_attendence) {
        this.avg_attendence = avg_attendence;
    }

    public List<Integer> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Integer> arrivals) {
        this.arrivals = arrivals;
    }

    public List<Integer> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Integer> departures) {
        this.departures = departures;
    }

    public String getInstagram_followers() {
        return instagram_followers;
    }

    public void setInstagram_followers(String instagram_followers) {
        this.instagram_followers = instagram_followers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
