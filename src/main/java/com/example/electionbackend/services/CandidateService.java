package com.example.electionbackend.services;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.repositories.CandidateRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService {
  private CandidateRepository candidateRepository;

  public String getAllCandidates() {
    JSONObject result = new JSONObject();
    if (!candidateRepository.findAll().isEmpty()){
      result.append("data", candidateRepository.findAll());
    }
    else{
      result.append("data", null);
    }
    return result.toString();
  }

  public Optional<Candidate> getCandidate(int id) {
    if(candidateRepository.findById(id).isPresent()){
      return candidateRepository.findById(id);
    }
    return Optional.empty();
  }
}
