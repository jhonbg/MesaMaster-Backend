package com.laempacadora.web.controller;

import com.laempacadora.Auth.AuthResponse;
import com.laempacadora.Auth.LoginRequest;
import com.laempacadora.Auth.RegisterRequest;
import com.laempacadora.domain.service.AuthService;
import com.laempacadora.domain.service.EmpleadoService;
import com.laempacadora.domain.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final EmpleadoService empleadoService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }


    @PostMapping(value = "register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request)
    {
        if(!empleadoService.getEmpleado(request.getIdEmpleado()).isPresent())
        {
            authService.register(request);
            return ResponseEntity.accepted().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
