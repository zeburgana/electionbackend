package com.example.electionbackend.repositories;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
  Optional<List<Vote>> findByCandidate(Candidate candidate);
  Optional<List<Vote>> findByVoterRegion(String region);
  @Query("SELECT DISTINCT COUNT (candidate), candidate.name FROM Vote")
  List<Pair<Integer, String>> countDistinctByCandidate();
}
