package com.learning_spring_boot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(PasswordEncoder encoder){
        Function<String, String> passwordEncoder= input->passwordEncoder().encode(input);

        UserDetails userDetails1 = createNewUser(passwordEncoder, "JeevaR", "Jeeva");
        UserDetails userDetails2 = createNewUser(passwordEncoder, "admin", "admin");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private static UserDetails createNewUser(Function<String, String> passwordEncoder, String userName, String password) {
        return User.builder()
              .passwordEncoder(passwordEncoder)
              .username(userName)
              .password(password)
              .roles("USER","ADMIN")
              .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth->
                    auth.anyRequest().authenticated()
        );
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return httpSecurity.build();
    }



}
