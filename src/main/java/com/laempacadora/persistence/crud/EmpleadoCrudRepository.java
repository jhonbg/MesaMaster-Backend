package com.laempacadora.persistence.crud;

import com.laempacadora.persistence.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, String> {
}
