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
  int countByCandidate(Candidate candidate);
  int countByVoterRegion(String region);
}
