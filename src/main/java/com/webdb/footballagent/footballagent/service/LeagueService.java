package com.webdb.footballagent.footballagent.service;


import com.webdb.footballagent.footballagent.exception.LeagueNotFoundException;
import com.webdb.footballagent.footballagent.model.League;
import com.webdb.footballagent.footballagent.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }


    public List<League> getAllLeagues(){
        return leagueRepository.findAll();
    }

//    public League getLeagueByName(String name) throws LeagueNotFoundException {
//        return leagueRepository.findByleague_name(name).orElseThrow(() -> new LeagueNotFoundException("The league with this name does not exist"));
//    }

}
