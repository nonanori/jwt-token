package com.example.demoautentikasi.controller;
import com.example.demoautentikasi.model.User;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {
    public JSONObject token(User user){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("acces_token", user.getUsername());
        jsonObject.put("name", user.getUsername());
        System.out.println("Token : " + jsonObject);
        return jsonObject;
    }

    @PostMapping("/user")
    public Map<String,Object> createUser(User user){
        return token(user).toMap();
    }

}
