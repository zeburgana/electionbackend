package com.example.electionbackend.services;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.models.Voter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class VoterServiceTest {

  Voter voter = new Voter(312312312, "Kaunas", null);
  Candidate candidate = new Candidate(1, "Guy", "For truth");
  @Autowired
  VoterService voterService;

  @Test
  void submitVote() {
    voterService.submitVote(voter.getId(), candidate.getNumber());
    assertTrue(voter.voted());
  }
}