package com.ironnestgym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ironnestgym.entity.User;
import com.ironnestgym.repository.UserRepository;

@Service
public class AuthenticationServiceimpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    

   
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }
}
