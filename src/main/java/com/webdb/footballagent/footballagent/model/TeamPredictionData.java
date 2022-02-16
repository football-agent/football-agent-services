package com.webdb.footballagent.footballagent.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class TeamPredictionData {

    @Field(name = "team_name")
    private String teamName;

    @Field(name = "prediction")
    private Double predictionValue;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getPredictionValue() {
        return predictionValue;
    }

    public void setPredictionValue(Double predictionValue) {
        this.predictionValue = predictionValue;
    }
}
