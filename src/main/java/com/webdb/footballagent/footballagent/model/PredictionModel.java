package com.webdb.footballagent.footballagent.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Document(collection = "predictions")
public class PredictionModel {


    @Field(name = "model")
    private List<PlayerPredictionData> playerPredictionDataList;

    public List<PlayerPredictionData> getPlayerPredictionDataList() {
        return playerPredictionDataList;
    }

    public void setPlayerPredictionDataList(List<PlayerPredictionData> playerPredictionDataList) {
        this.playerPredictionDataList = playerPredictionDataList;
    }
}
