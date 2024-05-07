package com.laempacadora.domain.service;

import com.laempacadora.persistence.EmpleadoRepository;
import com.laempacadora.persistence.entity.Empleado;
import com.laempacadora.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll()
    {
        return empleadoRepository.getAll();
    }

    public Optional<Empleado> getEmpleado(String idEmpleado)
    {
        return empleadoRepository.getEmpleado(idEmpleado);
    }

    public Empleado save(Empleado empleado)
    {
        return empleadoRepository.save(empleado);
    }

    public boolean delete(String idEmpleado)
    {
        return getEmpleado(idEmpleado).map(empleado -> {
            empleadoRepository.delete(idEmpleado);
            return true;
        }).orElse(false);
    }

    public boolean exists(String idEmpleado)
    {
        return getEmpleado(idEmpleado).isPresent();
    }

    public Empleado update(Empleado empleado)
    {
        return empleadoRepository.update(empleado);
    }
}
