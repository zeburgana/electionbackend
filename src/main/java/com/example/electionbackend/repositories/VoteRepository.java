package com.example.electionbackend.repositories;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
  //Counts votes by candidate
  int countByCandidate(Candidate candidate);
  //Counts votes by region first and then by candidate, could be done the other way around too
  int countByVoterRegionAndCandidate(String region, Candidate candidate);
}
