package com.example.electionbackend.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Generated;
import lombok.Setter;

@Entity
public class Voter {
  @Id
  @Setter(AccessLevel.NONE)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;
  private String region;
  @OneToOne
  private Vote vote;
}
