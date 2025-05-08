package com.example.BasicToAdvance.User.Service;

import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserSchema user = userRepository.findByEmail(email);
        System.out.println(user.getEmail() + " " + user.getPassword());
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()) // Password should be already hashed
                .roles(user.getRoles().toArray(new String[0])) // Assuming user has a role field
                .build();
        return userDetails;


    }
}
