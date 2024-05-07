package com.laempacadora.persistence.crud;

import com.laempacadora.persistence.entity.Mesa;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface MesaCrudRepository extends CrudRepository<Mesa, Integer> {
    Object findAll(Sort sort);
}
