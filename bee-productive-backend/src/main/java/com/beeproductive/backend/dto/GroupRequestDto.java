package com.beeproductive.backend.dto;

import com.beeproductive.backend.entity.Challenge;
import com.beeproductive.backend.entity.MemberDetails;
import com.beeproductive.backend.entity.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequestDto {
    private Long adminId;
    private String name;
    private Set<Long> challengeIds;
    private Set<Long> membersIds;
}
