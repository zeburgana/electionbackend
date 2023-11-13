package com.example.electionbackend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoteTest {

  Voter voter = new Voter(312312312, "Kaunas", null);
  Candidate candidate = new Candidate(1, "Guy", "For truth");
  Vote vote = new Vote(voter,candidate);

  @Test
  void getId() {
    assertEquals(vote.getId(), 1);
  }

  @Test
  void getVoter() {
    assertEquals(vote.getVoter(), voter);
  }

  @Test
  void getCandidate() {
    assertEquals(vote.getCandidate(), candidate);
  }
}