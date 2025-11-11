package com.beeproductive.backend.service;

import com.beeproductive.backend.dto.UserRequestDto;
import com.beeproductive.backend.entity.User;
import com.beeproductive.backend.mapper.UserMapper;
import com.beeproductive.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper;

}
