package com.laempacadora.domain.service;

import com.laempacadora.Auth.AuthResponse;
import com.laempacadora.Auth.LoginRequest;
import com.laempacadora.Auth.RegisterRequest;
import com.laempacadora.persistence.EmpleadoRepository;
import com.laempacadora.persistence.entity.Empleado;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EmpleadoRepository empleadoRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getIdEmpleado(), request.getContraseña()));
        UserDetails empleado = empleadoRepository.getEmpleado(request.getIdEmpleado()).orElseThrow();
        String token = jwtService.getToker(empleado);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public void register(RegisterRequest request)
    {
        Empleado empleado = Empleado.builder()
                .idEmpleado(request.getIdEmpleado())
                .nombre(request.getNombre())
                .contraseña(passwordEncoder.encode(request.getContraseña()))
                .rol(request.getRol())
                .estadoEmpleado(request.getEstadoEmpleado())
                .salario(request.getSalario())
                .build();

        empleadoRepository.save(empleado);
    }
}
