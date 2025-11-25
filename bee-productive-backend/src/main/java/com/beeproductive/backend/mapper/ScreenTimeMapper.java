package com.beeproductive.backend.mapper;

import com.beeproductive.backend.dto.ScreenTimeResponseDto;
import com.beeproductive.backend.entity.ScreenTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScreenTimeMapper {
    @Mapping(target="user",source="user.id")
    ScreenTimeResponseDto screenTimeToScreenTimeResponseDto(ScreenTime screenTime);
    List<ScreenTimeResponseDto> screenTimeToScreenTimeResponseDtoList(List<ScreenTime> screenTimes);
}
