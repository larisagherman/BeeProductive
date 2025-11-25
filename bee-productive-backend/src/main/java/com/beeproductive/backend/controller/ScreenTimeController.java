package com.beeproductive.backend.controller;

import com.beeproductive.backend.dto.ScreenTimeRequestDto;
import com.beeproductive.backend.dto.ScreenTimeResponseDto;
import com.beeproductive.backend.service.ScreenTimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/screen-time")
public class ScreenTimeController {
    private final ScreenTimeService screenTimeService;
    @PostMapping
    public void create(ScreenTimeRequestDto screenTimeRequestDto) {
        screenTimeService.create(screenTimeRequestDto);
    }
    @GetMapping
    public List<ScreenTimeResponseDto> getAll() {
        return screenTimeService.getAllScreenTimes();
    }
    @GetMapping("/{id}")
    public ScreenTimeResponseDto getById(@PathVariable("id")  Long id) {
        return screenTimeService.getScreenTimeById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        screenTimeService.deleteScreenTimeById(id);
    }


}
