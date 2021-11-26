package com.webdb.footballagent.footballagent.model.player;


public class InjuryHistory {

    private String injury;
    private String missed_games;

    public String getInjury() {
        return injury;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }

    public String getMissed_games() {
        return missed_games;
    }

    public void setMissed_games(String missed_games) {
        this.missed_games = missed_games;
    }
}
