package com.beeproductive.backend.dto;

import com.beeproductive.backend.entity.MemberKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailsRequestDto {
    private MemberKey memberKey;
}
