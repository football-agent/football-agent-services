package com.webdb.footballagent.footballagent.service;

import com.webdb.footballagent.footballagent.model.Player;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class PredictionService {

    private final TeamService teamService;

    public PredictionService(TeamService teamService) {
        this.teamService = teamService;
    }

    public void predictContractValue(Player playerToPredict) {
        List<Player> allPlayers = teamService.getAllPlayers();
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
// weight
        List<Double> wages = teamService.getAllPlayers().stream().map(player -> Objects.isNull(player.getWage_eur()) ? 0 : player.getWage_eur()).collect(Collectors.toList());
//        String[][] array = list.stream()
//                .map(l -> l.stream().toArray(String[]::new))
//                .toArray(String[][]::new);
        List<List<Double>> players = new ArrayList<>();

        for (int i = 0; i < allPlayers.size(); i++) {
            List<Double> featureList = new ArrayList<>();
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getAge()) ? 0 : allPlayers.get(i).getAge()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getAssists()) ? 0 : allPlayers.get(i).getAssists()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getCards_red()) ? 0 : allPlayers.get(i).getCards_red()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getDefending()) ? 0 : allPlayers.get(i).getDefending()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getCards_yellow()) ? 0 : allPlayers.get(i).getCards_yellow()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getDribbling()) ? 0 : allPlayers.get(i).getDribbling()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getGames()) ? 0 : allPlayers.get(i).getGames()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getMinutes()) ? 0 : allPlayers.get(i).getMinutes()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getOverall()) ? 0 : allPlayers.get(i).getOverall()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPace()) ? 0 : allPlayers.get(i).getPace()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPassing()) ? 0 : allPlayers.get(i).getPassing()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getPhysic()) ? 0 : allPlayers.get(i).getPhysic()));
            featureList.add((double) (Objects.isNull(allPlayers.get(i).getShooting()) ? 0 : allPlayers.get(i).getShooting()));
            players.add(featureList);
        }

// height, waist


        double[][] xPlayersArray = players.stream().map(l -> l.stream().mapToDouble(Double::doubleValue).toArray()).toArray(double[][]::new);

        double[] array = new double[wages.size()];
        for (int i = 0; i < wages.size(); i++) array[i] = wages.get(i);

        regression.newSampleData(array, xPlayersArray);

        double[] coe = regression.estimateRegressionParameters();

        double[] z = new double[allPlayers.size()];
        for (int i = 0; i < z.length; i++) {
            z[i] = coe[0];
            for (int j = 1; j < coe.length; j++) z[i] += coe[j] * xPlayersArray[i][j - 1];
        }

        for (double p : coe) {
            System.out.println(p);
        }
    }
}
