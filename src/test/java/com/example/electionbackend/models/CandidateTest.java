package com.example.electionbackend.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {

  Candidate candidate = new Candidate(1, "Guy", "For truth");

  @Test
  void getNumber() {
    assertEquals(candidate.getNumber(),1);
  }

  @Test
  void getName() {
    assertEquals(candidate.getName(), "Guy");
  }

  @Test
  void getSummary() {
    assertEquals(candidate.getSummary(), "For truth");
  }
}