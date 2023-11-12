package com.example.electionbackend.services;

import com.example.electionbackend.models.Vote;
import com.example.electionbackend.models.Voter;
import com.example.electionbackend.repositories.VoteRepository;
import com.example.electionbackend.repositories.VoterRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoterService {
  private VoterRepository voterRepository;
  private VoteRepository voteRepository;
  private CandidateService candidateService;

  public JSONObject submitVote(long voterId, int candidateId) {
    JSONObject response = new JSONObject();
    if(voterRepository.findById(voterId).isPresent() && candidateService.getCandidate(candidateId).isPresent()) {
      Voter voter = voterRepository.findById(voterId).get();
      if(voter.voted()) {
        response.append("message", "Failed to submit vote");
        return response;
      }

      Vote temporaryVote = new Vote(voterRepository.findById(voterId).get(),
              candidateService.getCandidate(candidateId).get());
      voter.setVote(voteRepository.save(temporaryVote));
      voterRepository.save(voter);
      response.append("message", "Successfully submitted vote for candidate No. " + candidateId);

      return response;
    }
    response.append("message", "Failed to submit vote");
    return response;
  }
}
