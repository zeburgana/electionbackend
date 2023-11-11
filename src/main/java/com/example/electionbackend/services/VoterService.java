package com.example.electionbackend.services;

import com.example.electionbackend.repositories.VoterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoterService {
  private VoterRepository voterRepository;

  public String submitVote(int voterId, int candidateId) {
    return null;
  }
}
