package com.webdb.footballagent.footballagent.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class Team {

     @Field
     private String team;
//    private String name;
//    private  String code;
//    private Titles titles;
//    private Map<String, LeagueRank> league_rank;
//    private Integer stadium_size;
//    private Integer avg_attendence;
//    private List<Integer> arrivals;
//    private List<Integer> departures;
//    private String instagram_followers;
//    private List<Player> players;

      private List<Player> players;


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
