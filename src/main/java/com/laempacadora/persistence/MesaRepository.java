package com.laempacadora.persistence;

import com.laempacadora.persistence.crud.MesaCrudRepository;
import com.laempacadora.persistence.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MesaRepository {
    @Autowired
    private MesaCrudRepository mesaCrudrepository;

    public List<Mesa> getAll()
    {
        return (List<Mesa>) mesaCrudrepository.findAll(Sort.by(Sort.Direction.ASC, "idMesa"));
    }

    public Optional<Mesa> getMesa(int idMesa)
    {
        return mesaCrudrepository.findById(idMesa);
    }

    public void delete(int idMesa)
    {
        mesaCrudrepository.deleteById(idMesa);
    }

    public Mesa save(Mesa mesa)
    {
        return mesaCrudrepository.save(mesa);
    }

    public Mesa update(Mesa mesa)
    {
        return mesaCrudrepository.save(mesa);
    }
}
