package com.example.electionbackend.controllers;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.services.*;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/election")
@AllArgsConstructor
public class ElectionController {
  CandidateService candidateService;
  VoterService voterService;
  StatisticsService statisticsService;

  //List endpoint

  /**
   * API Endpoint that returns a list of candidates
   * @return JSON list of candidates
   */
  @GetMapping("getCandidates")
  public List<Candidate> getCandidates(){
    return candidateService.getAllCandidates();
  }

  /**
   * API Endpoint that processes voting for a chosen candidate
   * @param voter Voter identification number
   * @param candidate Candidate number
   * @return Message of success or failure
   */
  @PostMapping("")
  public JSONObject voteForCandidate(@RequestParam long voter, @RequestParam int candidate){
    return voterService.submitVote(voter, candidate);
  }

  /**
   * API Endpoint that returns statistics of elections
   * @param type wanted type of statistics (total, regional, winner)
   * @return Json list of candidates
   */
  @GetMapping("statistics")
  public Map<String, Integer> statistics(@RequestParam String type){
    return statisticsService.getStatistics(type);
  }
}
