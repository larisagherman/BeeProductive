package com.beeproductive.backend.dto;

import com.beeproductive.backend.entity.ScreenTime;

import java.util.List;

public class UserResponseDto {
    private Long id;
    private int fireBaseId;
    private String Name;
    private int numberOfBees;
    private List<ScreenTime> screenTimes;
}
