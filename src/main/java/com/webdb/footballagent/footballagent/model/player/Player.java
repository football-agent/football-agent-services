package com.webdb.footballagent.footballagent.model.player;

import java.util.List;
import java.util.Map;

public class Player {

    private Integer player_id;
    private String date_of_birth;
    private Integer height;
    private String nationality;
    private Boolean national_team;
    private Boolean captain;
    private Map<String, List<String>> team_history;
    private PositionStatistics position_statistics;
    private Map<String, InjuryHistory> injury_history;
    private Map<String, Ranking> ranking;
    private Map<String, List<String>> personal_awards;
    private Map<String, Integer> market_value;
    private Integer instagram_followers;


    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getNational_team() {
        return national_team;
    }

    public void setNational_team(Boolean national_team) {
        this.national_team = national_team;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }



    public PositionStatistics getPosition_statistics() {
        return position_statistics;
    }

    public void setPosition_statistics(PositionStatistics position_statistics) {
        this.position_statistics = position_statistics;
    }

    public Map<String, List<String>> getTeam_history() {
        return team_history;
    }

    public void setTeam_history(Map<String, List<String>> team_history) {
        this.team_history = team_history;
    }

    public Map<String, InjuryHistory> getInjury_history() {
        return injury_history;
    }

    public void setInjury_history(Map<String, InjuryHistory> injury_history) {
        this.injury_history = injury_history;
    }

    public Map<String, Ranking> getRanking() {
        return ranking;
    }

    public void setRanking(Map<String, Ranking> ranking) {
        this.ranking = ranking;
    }

    public Map<String, List<String>> getPersonal_awards() {
        return personal_awards;
    }

    public void setPersonal_awards(Map<String, List<String>> personal_awards) {
        this.personal_awards = personal_awards;
    }

    public Map<String, Integer> getMarket_value() {
        return market_value;
    }

    public void setMarket_value(Map<String, Integer> market_value) {
        this.market_value = market_value;
    }

    public Integer getInstagram_followers() {
        return instagram_followers;
    }

    public void setInstagram_followers(Integer instagram_followers) {
        this.instagram_followers = instagram_followers;
    }
}
