package com.webdb.footballagent.footballagent.model;

import java.util.List;

public class Titles {
    private List<Integer> national_championship;
    private List<Integer> champions_league;
    private List<Integer> region_cup;

    public List<Integer> getNational_championship() {
        return national_championship;
    }

    public void setNational_championship(List<Integer> national_championship) {
        this.national_championship = national_championship;
    }

    public List<Integer> getChampions_league() {
        return champions_league;
    }

    public void setChampions_league(List<Integer> champions_league) {
        this.champions_league = champions_league;
    }

    public List<Integer> getRegion_cup() {
        return region_cup;
    }

    public void setRegion_cup(List<Integer> region_cup) {
        this.region_cup = region_cup;
    }
}
