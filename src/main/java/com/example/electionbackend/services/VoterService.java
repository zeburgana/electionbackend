package com.example.electionbackend.services;

import com.example.electionbackend.models.Vote;
import com.example.electionbackend.models.Voter;
import com.example.electionbackend.repositories.VoteRepository;
import com.example.electionbackend.repositories.VoterRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class VoterService {
  private VoterRepository voterRepository;
  private VoteRepository voteRepository;
  private CandidateService candidateService;

  public Map<String,String> submitVote(long voterId, int candidateId) {
    Map<String, String> response = new HashMap<>();

    if(voterRepository.findById(voterId).isPresent() && candidateService.getCandidate(candidateId).isPresent()) {
      Voter voter = voterRepository.findById(voterId).get();

      if(voter.voted()) {
        response.put("message", "Failed to submit vote");
      } else {
        Vote temporaryVote = new Vote(voterRepository.findById(voterId).get(),
                candidateService.getCandidate(candidateId).get());
        voter.setVote(voteRepository.save(temporaryVote));
        voterRepository.save(voter);

        response.put("message", "Successfully submitted vote for candidate No. " + candidateId);
      }
    } else {
      response.put("message", "Failed to submit vote");
    }
    return response;
  }
}
