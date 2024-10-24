package com.ProiectareSoftware.dreamCatch.controller;

import com.ProiectareSoftware.dreamCatch.dto.request.LoginRequest;
import com.ProiectareSoftware.dreamCatch.dto.request.RegisterRequest;
import com.ProiectareSoftware.dreamCatch.dto.response.AuthenticationResponse;
import com.ProiectareSoftware.dreamCatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }
}
