package com.learning.gateway.ApiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                // Secure all endpoints
                .authorizeExchange(authorize -> authorize
                        .anyExchange().authenticated()
                )
                // Enable OAuth2 client support
                .oauth2Client(withDefaults())
                // Enable JWT-based resource server
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwtSpec -> {})
                );

        return http.build();
    }
}
