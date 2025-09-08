package com.learning.gateway.ApiGateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String userId;
    private String email;
    private String accessToken;
    private String refreshToken;
    private long expiresIn;
    private Collection<String> authority;
}
