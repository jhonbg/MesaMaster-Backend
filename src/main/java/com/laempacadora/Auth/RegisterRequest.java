package com.laempacadora.Auth;

import com.laempacadora.domain.EstadoEmpleado;
import com.laempacadora.domain.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String idEmpleado;

    private String nombre;

    private String contraseña;

    private Roles rol;

    private EstadoEmpleado estadoEmpleado;

    private Double salario;
}
