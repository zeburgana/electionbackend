package com.example.electionbackend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoterTest {

  Voter voter = new Voter(312312312, "Kaunas", null);

  @Test
  void getId(){
    assertEquals(voter.getId(), 312312312);
  }

  @Test
  void getRegion(){
    assertEquals(voter.getRegion(), "Kaunas");
  }

  @Test
  void getVote(){
    assertNull(voter.getVote());
  }
  @Test
  void voted() {
    assertFalse(voter.voted());
  }
}