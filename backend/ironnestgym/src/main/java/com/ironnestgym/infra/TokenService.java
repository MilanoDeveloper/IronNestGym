package com.ironnestgym.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ironnestgym.entity.User;

@Service
public class TokenService {
    
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                .withIssuer("APIronGym")
                .withSubject(user.getLogin())
                .withExpiresAt(dataExpiration())
                .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Token generation error", exception);
        }
    }

    private Instant dataExpiration(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
