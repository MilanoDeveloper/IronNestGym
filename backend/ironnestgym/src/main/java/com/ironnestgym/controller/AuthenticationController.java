package com.ironnestgym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ironnestgym.entity.AuthenticationData;
import com.ironnestgym.entity.User;
import com.ironnestgym.infra.TokenService;
import com.ironnestgym.service.AuthenticationServiceimpl;

@RequestMapping("/login")
@RestController
public class AuthenticationController {
    @Autowired
    PasswordEncoder passBC;

    @Autowired
    AuthenticationServiceimpl authenticationServiceimpl;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Validated AuthenticationData loginData){
        var token = new UsernamePasswordAuthenticationToken(loginData.login(), loginData.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.generateToken((User)authentication.getPrincipal()));

    }

    @PostMapping("/user")
    public User savePerson(@RequestBody User user) { 
        user.setPassword(passBC.encode(user.getPassword()));           
        return authenticationServiceimpl.saveUser(user);

        
    }
}
