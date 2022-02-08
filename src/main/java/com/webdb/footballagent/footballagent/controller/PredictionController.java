package com.webdb.footballagent.footballagent.controller;


import com.webdb.footballagent.footballagent.model.Player;
import com.webdb.footballagent.footballagent.model.Prediction;
import com.webdb.footballagent.footballagent.service.PredictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/football_agent/prediction")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PredictionController {

    private  final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    @GetMapping(value = "predict/{player_name}")
    public Prediction getPrediction(@PathVariable String player_name){
        return predictionService.predictContractValue(player_name);
    }
}
