package com.ProiectareSoftware.dreamCatch.dto.response;

import com.ProiectareSoftware.dreamCatch.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private UserDTO user;

    private String accessToken;
}
