package com.beeproductive.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponseDto {
    private Long id;
    private String name;
    private Long userAdmin;
    private Set<Long> challengeIds;
    private Set<Long> memberData;
}
