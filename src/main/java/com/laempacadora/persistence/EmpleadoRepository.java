package com.laempacadora.persistence;

import com.laempacadora.persistence.crud.EmpleadoCrudRepository;
import com.laempacadora.persistence.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class EmpleadoRepository {
    @Autowired
    private EmpleadoCrudRepository empleadoCrudRepository;

    public List<Empleado> getAll()
    {
        return (List<Empleado>) empleadoCrudRepository.findAll();
    }

    public Optional<Empleado> getEmpleado(String idEmpleado)
    {
        return empleadoCrudRepository.findById(idEmpleado);
    }

    public Empleado save(Empleado empleado)
    {
        return empleadoCrudRepository.save(empleado);
    }

    public void delete(String idEmpleado)
    {
        empleadoCrudRepository.deleteById(idEmpleado);
    }

    public Empleado update(Empleado empleado) {
        Optional<Empleado> existingEmpleadoOptional = getEmpleado(empleado.getIdEmpleado());
        if (existingEmpleadoOptional.isPresent()) {
            Empleado existingEmpleado = existingEmpleadoOptional.get();
            existingEmpleado.setRol(empleado.getRol());
            existingEmpleado.setEstadoEmpleado(empleado.getEstadoEmpleado());
            existingEmpleado.setSalario(empleado.getSalario());
            return empleadoCrudRepository.save(existingEmpleado);
        }
        return null;
    }

}
