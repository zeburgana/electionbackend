package com.example.electionbackend.services;

import com.example.electionbackend.repositories.CandidateRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

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

  public String getCandidate(int id) {
    JSONObject result = new JSONObject();
    if(candidateRepository.findById(id).isPresent()){
      result.append("ha", "ha");
    }
    else{
      result.append("Error:", "haha");
    }
    return result.toString();
  }
}
