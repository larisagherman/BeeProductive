package com.beeproductive.backend.service;

import com.beeproductive.backend.entity.User;
import com.beeproductive.backend.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void login(String token) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String userId = decodedToken.getUid();
        String name= decodedToken.getName();
        Optional<User> user=userRepository.findByFireBaseId(token);
        if(user.isEmpty()){
            register(userId, name);
        }

    }
    public void register(String firebaseUId, String name) {
        User user = new User();
        user.setFireBaseId(firebaseUId);
        user.setName(name);
        userRepository.save(user);
    }
}
