package com.webdb.footballagent.footballagent.service;

import com.webdb.footballagent.footballagent.model.PredictionModel;
import com.webdb.footballagent.footballagent.model.TeamPredictionData;
import com.webdb.footballagent.footballagent.repository.PredictionRepository;
import com.webdb.footballagent.footballagent.response.Prediction;
import org.springframework.stereotype.Service;


@Service
public class PredictionService {

    private final PredictionRepository predictionRepository;

    public PredictionService(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

//    private final TeamService teamService;
//
//    public PredictionService(TeamService teamService) {
//        this.teamService = teamService;
//    }
//
//    public Prediction predictContractValue(String  playerName) {
//        List<Player> allPlayers = teamService.getAllPlayers();
//        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
//        List<Double> wages = teamService.getAllPlayers().stream().map(player -> Objects.isNull(player.getWage_eur()) ? 0 : player.getWage_eur()).collect(Collectors.toList());
//        List<List<Double>> players = new ArrayList<>();
//        Map<String , List<Double>> playerMap = new HashMap<>();
//
//
//        for (int i = 0; i < allPlayers.size(); i++) {
//            List<Double> featureList = new ArrayList<>();
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getAge()) ? 0 : allPlayers.get(i).getAge()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getAssists()) ? 0 : allPlayers.get(i).getAssists()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getCards_red()) ? 0 : allPlayers.get(i).getCards_red()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getDefending()) ? 0 : allPlayers.get(i).getDefending()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getCards_yellow()) ? 0 : allPlayers.get(i).getCards_yellow()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getDribbling()) ? 0 : allPlayers.get(i).getDribbling()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getGames()) ? 0 : allPlayers.get(i).getGames()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getMinutes()) ? 0 : allPlayers.get(i).getMinutes()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getOverall()) ? 0 : allPlayers.get(i).getOverall()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPace()) ? 0 : allPlayers.get(i).getPace()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPassing()) ? 0 : allPlayers.get(i).getPassing()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPhysic()) ? 0 : allPlayers.get(i).getPhysic()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getShooting()) ? 0 : allPlayers.get(i).getShooting()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getGoals()) ? 0 : allPlayers.get(i).getGoals()));
//            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPotential()) ? 0 : allPlayers.get(i).getPotential()));
//
//
//            players.add(featureList);
//            playerMap.put(allPlayers.get(i).getPlayer(), featureList);
//        }
//
//        double[][] xPlayersArray = players.stream().map(l -> l.stream().mapToDouble(Double::doubleValue).toArray()).toArray(double[][]::new);
//
//        double[] array = new double[wages.size()];
//        for (int i = 0; i < wages.size(); i++) array[i] = wages.get(i);
//
//        regression.newSampleData(array, xPlayersArray);
//
//        double[] coe = regression.estimateRegressionParameters();
//
//
//        Double predictedValue = coe[0];
//        for (int i =0 ; i<playerMap.get(playerName).size(); i++){
//           predictedValue+=coe[i+1] * playerMap.get(playerName).get(i);
//        }
//        Prediction prediction = new Prediction();
//        prediction.setPredictedValue(predictedValue);
//        prediction.setPlayerName(playerName);
//
//        return prediction;
//    }

    public Prediction getPrediction(String playerName, String teamName) {
        PredictionModel predictionModel = predictionRepository.findAll().stream().findFirst().get();
        TeamPredictionData teamPredictionDataObject=predictionModel.getPlayerPredictionDataList().stream().filter(playerPredictionData -> playerPredictionData.getPlayerName().equals(playerName)).findFirst().get().getTeamPredictionDataList().stream().filter(teamPredictionData -> teamPredictionData.getTeamName().equals(teamName)).findFirst().get();
        Prediction prediction = new Prediction();
        prediction.setPredictedValue(teamPredictionDataObject.getPredictionValue());
        prediction.setPlayerName(playerName);
        prediction.setTeamName(teamName);
        return prediction;
    }

}
