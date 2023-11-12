package com.example.electionbackend.controllers;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.services.*;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/election")
@AllArgsConstructor
public class ElectionController {
  CandidateService candidateService;
  VoterService voterService;
  StatisticsService statisticsService;

  //List function
  @GetMapping("getCandidates")
  public List<Candidate> getCandidates(){
    return candidateService.getAllCandidates();
  }
  //Voting function
  @PostMapping("")
  public JSONObject voteForCandidate(@RequestParam long voter, @RequestParam int candidate){
    return voterService.submitVote(voter, candidate);
  }
  //Statistics function
  @GetMapping("statistics")
  public JSONObject statistics(@RequestParam String type){
    return statisticsService.getStatistics(type);
  }
}
