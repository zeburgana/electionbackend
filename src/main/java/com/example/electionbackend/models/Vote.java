package com.example.electionbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Vote {
  @Id
  @Setter(AccessLevel.NONE)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int Id;
  @OneToOne
  Voter voter;
  @OneToOne
  Candidate candidate;
}