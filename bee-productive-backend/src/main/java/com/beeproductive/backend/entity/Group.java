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
@Table(name="group_")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "adminId")
    private User userAdmin;

    @ManyToMany(mappedBy = "groupList")
    private Set<Challenge> challengeList;

    @OneToMany(mappedBy = "group")
    private Set<MemberDetails> memberData;






}
