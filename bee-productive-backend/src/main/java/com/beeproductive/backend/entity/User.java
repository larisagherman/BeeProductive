package com.beeproductive.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String fireBaseId;
    @Column(nullable = false)
    private String name;
    @Column
    private int numberOfBees;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ScreenTime> screenTimes;

    //the groups where this user is admin
    @OneToMany(mappedBy = "userAdmin")
    private Set<Group> adminGroups;

    //the groups where this user is a member
    @OneToMany(mappedBy = "user")
    private Set<MemberDetails> groupData;

}
