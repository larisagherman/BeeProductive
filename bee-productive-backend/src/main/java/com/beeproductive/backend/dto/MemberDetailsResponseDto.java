package com.beeproductive.backend.dto;

import com.beeproductive.backend.entity.MemberKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MemberDetailsResponseDto {
    private MemberKey memberKey;
    private int kgOfHoney;
}
