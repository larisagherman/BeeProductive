package com.beeproductive.backend.service;

import com.beeproductive.backend.dto.ScreenTimeRequestDto;
import com.beeproductive.backend.dto.ScreenTimeResponseDto;
import com.beeproductive.backend.entity.ScreenTime;
import com.beeproductive.backend.mapper.ScreenTimeMapper;
import com.beeproductive.backend.repository.ScreenTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScreenTimeService {
    private final ScreenTimeRepository screenTimeRepository;
    private final ScreenTimeMapper screenTimeMapper;
    public void create(ScreenTimeRequestDto screenTimeRequestDto) {
        ScreenTime screenTime=new ScreenTime();
        //save from api

        screenTimeRepository.save(screenTime);
    }
    public ScreenTimeResponseDto getScreenTimeById(Long id) {
        ScreenTime screenTime = screenTimeRepository.findById(id).orElseThrow(()->new RuntimeException("Screen time not found"));
        return screenTimeMapper.screenTimeToScreenTimeResponseDto(screenTime);
    }
    public List<ScreenTimeResponseDto> getAllScreenTimes() {
        List<ScreenTime> screenTimes = screenTimeRepository.findAll();
        return screenTimeMapper.screenTimeToScreenTimeResponseDtoList(screenTimes);
    }

    public void deleteScreenTimeById(Long id) {
        ScreenTime screenTime=screenTimeRepository.findById(id).orElseThrow(()->new RuntimeException("Screen time not found"));
        screenTimeRepository.delete(screenTime);
    }
}
