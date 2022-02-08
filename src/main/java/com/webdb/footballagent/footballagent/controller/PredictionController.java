package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.model.Player;
import com.webdb.footballagent.footballagent.service.PredictionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/football_agent/prediction")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PredictionController {

    private  final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    @GetMapping(value = "predict")
    public void getPlayers(){
        predictionService.test();
    }
}
