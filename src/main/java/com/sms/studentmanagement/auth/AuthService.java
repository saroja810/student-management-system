package com.sms.studentmanagement.auth;

import com.sms.studentmanagement.entity.User;
import com.sms.studentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.sms.studentmanagement.dto.RegisterRequest;

@Service
public class AuthService {
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String register(RegisterRequest request){

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return "Email already exsistes";
        }
        User user = new User();

        user.setEmail(request.getEmail());

        user.setPassword(
                encoder.encode(
                        request.getPassword()
                )
        );

        user.setRole("USER");

        userRepository.save(user);

        return "Registration successful";
    }
}
