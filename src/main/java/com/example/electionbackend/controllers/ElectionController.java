package com.example.electionbackend.controllers;

import com.example.electionbackend.services.CandidateService;
import com.example.electionbackend.services.StatisticsService;
import com.example.electionbackend.services.VoterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/election")
@AllArgsConstructor
public class ElectionController {
  CandidateService candidateService;
  VoterService voterService;
  StatisticsService statisticsService;

  //List
  @GetMapping("getCandidates")
  public String getCandidates(){
    return candidateService.getAllCandidates();
  }
//  @GetMapping("getCandidate={id}")
//  public String getCandidates(@RequestParam int id){
//    return candidateService.getCandidate(id).toString();
//  }
  //Vote
  @PostMapping("")
  public String voteForCandidate(@RequestParam long voter, @RequestParam int candidate){
    return voterService.submitVote(voter, candidate);
  }
  //Statistics
  @GetMapping("statistics")
  public String statistics(@RequestParam String type){
    return statisticsService.getStatistics(type);
  }
}
