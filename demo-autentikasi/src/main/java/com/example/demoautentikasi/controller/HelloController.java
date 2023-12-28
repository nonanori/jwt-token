package com.example.demoautentikasi.controller;
import com.example.demoautentikasi.model.JWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class HelloController {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    @PostMapping("/hello")
    public Map<String,Object> generateJwt(@RequestBody JWT jwtRequest) {
        String jwtToken = createJwt(jwtRequest.getUsername());
        Map<String,Object> response=Map.of(
                "token", jwtToken,
                "username",jwtRequest.getUsername()
        );
        return response;
    }

    private String createJwt(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(key,SignatureAlgorithm.HS512)
                .compact();
    }
}
