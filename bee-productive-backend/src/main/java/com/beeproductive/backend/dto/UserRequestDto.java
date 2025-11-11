package com.beeproductive.backend.dto;

import com.beeproductive.backend.entity.Group;
import com.beeproductive.backend.entity.MemberDetails;
import com.beeproductive.backend.entity.ScreenTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private int fireBaseId;
    private String Name;
}
