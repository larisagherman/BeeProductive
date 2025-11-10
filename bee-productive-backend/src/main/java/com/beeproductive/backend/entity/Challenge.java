package com.beeproductive.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "challenge")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "challenge_group",
                joinColumns = @JoinColumn(name = "challenge_id"),
            inverseJoinColumns=@JoinColumn(name = "group_id"))
    Set<Group> groupList;
}
