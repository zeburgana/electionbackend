package com.example.electionbackend.services;

import com.example.electionbackend.models.Vote;
import com.example.electionbackend.repositories.VoteRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class StatisticsService {
  private VoteRepository voteRepository;

  public JSONObject getStatistics(String type) {
    JSONObject result = new JSONObject();
    List<Vote> voteList;
    Map<String, Integer> candidateMap = new HashMap<>();

    if(!type.isEmpty()){
      if(!voteRepository.findAll().isEmpty()) {
        voteList = voteRepository.findAll();
        switch (type) {
          case "total" -> { //iterate over each element and add it up by Candidate
            for (Vote element : voteList) {
              candidateMap.put(element.getCandidate().getName(), voteRepository.countByCandidate(element.getCandidate()));
            }
            result.put("",candidateMap);
          }
          case "regional" -> { //iterate over each element and add it up by region
            for (Vote element : voteList) {
              candidateMap.put(element.getVoter().getRegion(), voteRepository.countByVoterRegion(element.getVoter().getRegion()));
            }
            result = new JSONObject(candidateMap);
          }
          case "winner" -> { //iterate over each element and add it up by Candidate
            for (Vote element : voteList) {
              candidateMap.put(element.getCandidate().getName(), voteRepository.countByCandidate(element.getCandidate()));
            }
            //Pick out max value from the list
            result = new JSONObject(Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue()));
            //If the winner does not have more than 50% votes, add the closest candidate
            if ((float) Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue()).getValue() / voteList.size() < .5) {
              //Remove the biggest value from the map
              candidateMap.remove(Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue()).getKey());
              //Add the next biggest value to the result
              result.put("",Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue()));
            }
          }
          default -> result.put("", "Failed to fetch statistics");
        }
      }
      result.put("", "Failed to fetch statistics");
    }
    return result;
  }
}
