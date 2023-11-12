package com.example.electionbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Candidate {
  @Id
  @Setter(AccessLevel.NONE)
  private int number;
  private String name;
  private String summary;
}
