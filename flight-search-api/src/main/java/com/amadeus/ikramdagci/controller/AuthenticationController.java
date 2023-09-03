package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.request.AuthenticationRequest;
import com.amadeus.ikramdagci.domain.model.request.RegisterRequest;
import com.amadeus.ikramdagci.domain.model.response.AuthenticationResponse;
import com.amadeus.ikramdagci.domain.service.security.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "1- Authentication", description = "Endpoints for searching flights")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @Operation(summary = "User Registration", description = "Allows users to register with email and password.")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(service.register(registerRequest));
    }

    @PostMapping("/authenticate")
    @Operation(summary = "User Authentication", description = "Allows users to authenticate with their email and password.")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(service.authenticate(authenticationRequest));
    }

}
