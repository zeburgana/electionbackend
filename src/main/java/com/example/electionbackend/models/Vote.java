package com.example.electionbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
public class Vote {
  @Id
  @Setter(AccessLevel.NONE)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int Id;
  @OneToOne
  Voter voter;
  @ManyToOne
  Candidate candidate;

  public Vote(Voter voter, Candidate candidate){
    this.voter = voter;
    this.candidate = candidate;
  }
}