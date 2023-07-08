package com.assignment.GithubEvent.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type;


    @JsonProperty("public")
    boolean eventPublic;

    int repoId;

    int actorId;

}
