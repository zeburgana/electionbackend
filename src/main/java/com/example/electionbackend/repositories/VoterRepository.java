package com.example.electionbackend.repositories;

import com.example.electionbackend.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {
  Optional<Voter> findById(long id);
}
