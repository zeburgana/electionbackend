package com.example.electionbackend.repositories;

import com.example.electionbackend.models.Candidate;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
  Optional<Candidate> findByNumber(int number);
}
