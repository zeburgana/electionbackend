package com.example.electionbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
  @Id
  @Setter(AccessLevel.NONE)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;
  private String region;
  @OneToOne
  private Vote vote;

  public boolean voted(){
    return vote != null;
  }
}
