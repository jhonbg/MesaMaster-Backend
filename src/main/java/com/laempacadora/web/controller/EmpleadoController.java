package com.laempacadora.web.controller;

import com.laempacadora.domain.service.EmpleadoService;
import com.laempacadora.persistence.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:8090"})
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAll()
    {
        return new ResponseEntity<>(empleadoService.getAll(), HttpStatus.OK);
    }
    @Value("${jwt.secret}")
    private String jwtSecret;
    @GetMapping("/{id}")

    public ResponseEntity<Optional<Empleado>> getEmpleado(@PathVariable("id") String token) {
        String idEmpleado = extractIdEmpleadoFromToken(token);

        return new ResponseEntity<>(empleadoService.getEmpleado(idEmpleado), HttpStatus.ACCEPTED);
    }

    private String extractIdEmpleadoFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        // Aquí asumimos que el id del empleado está almacenado en el claim 'idEmpleado'
        return claims.get("sub", String.class);
    }



    @PostMapping("/save")
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado)
    {
        if(empleadoService.exists(empleado.getIdEmpleado()) == false)
        {
            return new ResponseEntity<>(empleadoService.save(empleado),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String idEmpleado)
    {
        return new ResponseEntity<>(empleadoService.delete(idEmpleado),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado)
    {
        if(empleadoService.exists(empleado.getIdEmpleado()) == true)
        {
            return new ResponseEntity<>(empleadoService.update(empleado),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
