package com.sl.ecom.controller;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ecom.Repository.UserRepository;
import com.sl.ecom.dto.AuthenticationRequest;
import com.sl.ecom.entity.User;
import com.sl.ecom.utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";

    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws JSONException, IOException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect Username or Password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        
        if (optionalUser.isPresent()) {
            response.getWriter().write(new JSONObject()
            .put("userId",optionalUser.get().getId())
            .put("role",optionalUser.get().getRole())
            .toString()
            );
            
            response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
        }

    }

}
