package com.example.electionbackend.services;

import com.example.electionbackend.models.Vote;
import com.example.electionbackend.repositories.VoteRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
  private VoteRepository voteRepository;

  public String getStatistics(String type) {
    JSONObject result = new JSONObject();
    List<Vote> list;
    if(!type.isEmpty()){
      if(!voteRepository.findAll().isEmpty())
      {
        list = voteRepository.findAll();
        switch (type){
          case "total":
            for (Vote element:
                 list) {
              //iterate over each element and add it up OR write an sql query from the repository class
            }
              case "regional":
                //iterate over each element and add it up OR write an sql query from the repository class
          case "winner": //returns winner >50% or two most popular
            //iterate over each element and add it up OR write an sql query from the repository class
          default:
      }
      }
    }
    return result.toString();
  }
}
