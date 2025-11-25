package com.beeproductive.backend.service;

import com.beeproductive.backend.dto.UserResponseDto;
import com.beeproductive.backend.entity.User;
import com.beeproductive.backend.mapper.UserMapper;
import com.beeproductive.backend.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public void login(String token) {
//this is just a mok login cause we do not have the firebase login just yet

        Optional<User> user=userRepository.findByFireBaseId(token);
        if(user.isEmpty()){
            register(token, "test name");
        }

    }
    public void register(String firebaseUId, String name) {
        User user = new User();
        user.setFireBaseId(firebaseUId);
        user.setName(name);
        user.setNumberOfBees(10);
        userRepository.save(user);
    }
    public List<UserResponseDto> getAllUsers() {
        List<User> users=userRepository.findAll();
        return userMapper.usersToDtoResponses(users);
    }
    public UserResponseDto getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User was not found"));
        return userMapper.userToDtoResponse(user);
    }
    public void deleteUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User was not found"));
        userRepository.delete(user);
    }
}
