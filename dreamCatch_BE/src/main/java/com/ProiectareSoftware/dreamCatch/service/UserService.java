package com.ProiectareSoftware.dreamCatch.service;

import com.ProiectareSoftware.dreamCatch.dto.request.LoginRequest;
import com.ProiectareSoftware.dreamCatch.dto.request.RegisterRequest;
import com.ProiectareSoftware.dreamCatch.dto.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);

    ResponseEntity<?> register(RegisterRequest registerRequest);
}
