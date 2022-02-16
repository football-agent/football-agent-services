package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.response.Prediction;
import com.webdb.footballagent.footballagent.service.PredictionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/football_agent/prediction")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PredictionController {

    private  final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    @GetMapping(value = "predict/{player_name}/{team_name}")
    public Prediction getPrediction(@PathVariable String player_name, @PathVariable  String team_name){
        return predictionService.getPrediction(player_name, team_name);
    }
}
