package com.webdb.footballagent.footballagent.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class PlayerPredictionData {

    @Field(name = "name")
    private String playerName;

    @Field(name = "predictions")
    private List<TeamPredictionData> teamPredictionDataList;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<TeamPredictionData> getTeamPredictionDataList() {
        return teamPredictionDataList;
    }

    public void setTeamPredictionDataList(List<TeamPredictionData> teamPredictionDataList) {
        this.teamPredictionDataList = teamPredictionDataList;
    }
}
