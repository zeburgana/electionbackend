package com.example.electionbackend.services;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.repositories.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService {
  private CandidateRepository candidateRepository;

  /**
   *
   * @return Candidate List
   */
  public List<Candidate> getAllCandidates() {
   return candidateRepository.findAll();
  }

  /**
   *
   * @param id of the candidate
   * @return Candidate by ID
   */
  public Optional<Candidate> getCandidate(int id) {
    return candidateRepository.findById(id);
  }
}
