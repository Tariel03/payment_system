package com.example.dd.controllers;

import com.example.dd.dto.request.UserRequest;
import com.example.dd.dto.response.TokenResponse;
import com.example.dd.entities.AppUser;
import com.example.dd.security.AppUserDetailsService;
import com.example.dd.security.RegistrationServiceImpl;
import com.example.dd.services.impl.AppUserImpl;
import com.example.dd.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    AppUserImpl userService;
    RegistrationServiceImpl registrationService;
    AuthenticationManager authenticationManager;
        JwtUtil jwtUtil;
        MessageSource messageSource;
        @PostMapping("/registration")
        @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://correct-certain-quail.ngrok-free.app","https://correct-certain-quail.ngrok-free.app"})
//    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
        public ResponseEntity<TokenResponse> performRegistration(@RequestBody UserRequest userRequest) {
            String message  = "";
            //Проверяет нет ли такого человека уже
            if(userService.findByUsername(userRequest.getUsername()).isPresent()) {
                message = "User by this username exists";
                throw new BadCredentialsException(message);
            }
            registrationService.registration(userRequest);
            String accessToken = jwtUtil.generateAccessToken(userRequest.getUsername());
            String refreshToken = jwtUtil.generateRefreshToken(userRequest.getUsername());

           TokenResponse tokenResponse =  TokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
            //Если все норм то токен выдает!
            return ResponseEntity.ok(tokenResponse);
        }

        @PostMapping("/login")
        @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://correct-certain-quail.ngrok-free.app","https://correct-certain-quail.ngrok-free.app"})
        @Operation(summary = "Login", description = "This request is used for logging in")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "successful operation",
                        content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))) })
        public ResponseEntity< TokenResponse> performLogin(@RequestBody UserRequest request) {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword());
            String accessToken;
            String refreshToken;
            try {
                authenticationManager.authenticate(authInputToken);
                 accessToken = jwtUtil.generateAccessToken(request.getUsername());
                 refreshToken = jwtUtil.generateRefreshToken(request.getUsername());
            } catch (BadCredentialsException e) {
                accessToken = "Error";
                refreshToken = "Error";
            }

            TokenResponse tokenResponse =  TokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
            //Если все норм то токен выдает!
            return ResponseEntity.ok(tokenResponse);
        }

        @PostMapping("/refresh")
        @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://correct-certain-quail.ngrok-free.app","https://correct-certain-quail.ngrok-free.app"})
    public ResponseEntity<Map<String,String>> refreshTokenResponse(String refreshToken){
            String accessToken = jwtUtil.generateAccessToken((jwtUtil.validateTokenAndRetrieveClaim(refreshToken)));
            return ResponseEntity.ok(Map.of("access-token",accessToken));
        }




}
