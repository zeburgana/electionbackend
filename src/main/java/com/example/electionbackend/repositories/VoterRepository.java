package com.example.electionbackend.repositories;

import com.example.electionbackend.models.Candidate;
import com.example.electionbackend.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {
  Optional<List<Voter>> findAllByRegion(String region);
  Optional<Voter> findById(long id);
}
