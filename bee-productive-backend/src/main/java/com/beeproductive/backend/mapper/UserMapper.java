package com.beeproductive.backend.mapper;

import com.beeproductive.backend.dto.UserRequestDto;
import com.beeproductive.backend.dto.UserResponseDto;
import com.beeproductive.backend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto dtoRequestToDtoResponse(UserRequestDto userRequestDto);
    User requestDtoToUser(UserRequestDto userRequestDto);
    UserResponseDto userToDtoResponse(User user);

}
