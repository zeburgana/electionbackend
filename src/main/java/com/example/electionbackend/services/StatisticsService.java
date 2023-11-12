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

  public Map<String, Integer> getStatistics(String type) {
    List<Vote> voteList;
    Map<String, Integer> candidateMap = new HashMap<>();
    Map<String, Integer> resultMap = new HashMap<>();

    if(!type.isEmpty()){
      if(!voteRepository.findAll().isEmpty()) {
        voteList = voteRepository.findAll();
        switch (type) {
          case "total" -> { //iterate over each element and add it up by Candidate
            for (Vote element : voteList) {
              candidateMap.put(element.getCandidate().getName(), voteRepository.countByCandidate(element.getCandidate()));
            }
            return candidateMap;
          }
          case "regional" -> { //iterate over each element and add it up by region
            for (Vote element : voteList) {
              //Create a map of Candidates name and a voter that voted for him in that region
              candidateMap.put(element.getCandidate().getName() + ", " + element.getVoter().getRegion(),
                      voteRepository.countByVoterRegionAndCandidate(element.getVoter().getRegion(), element.getCandidate()));
            }
            return candidateMap;
          }
          case "winner" -> { //iterate over each element and add it up by Candidate
            for (Vote element : voteList) {
              candidateMap.put(element.getCandidate().getName(), voteRepository.countByCandidate(element.getCandidate()));
            }
            Map.Entry<String, Integer> biggestEntry =
                    (Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue()));

            //Pick out max value from the list
            resultMap.put(biggestEntry.getKey(), biggestEntry.getValue());
            //If the winner does not have more than 50% votes, add the closest candidate
            if ((float) Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue()).getValue() / voteList.size() < .5) {
              //Remove the biggest value from the map
              candidateMap.remove(biggestEntry.getKey(), biggestEntry.getValue());
              //Get the next biggest value
              biggestEntry = Collections.max(candidateMap.entrySet(), Map.Entry.comparingByValue());
              //put the biggest value into the result map
              resultMap.put(biggestEntry.getKey(), biggestEntry.getValue());
            }
            candidateMap = resultMap;
          }
        }
      }
    }
    return candidateMap;
  }
}
