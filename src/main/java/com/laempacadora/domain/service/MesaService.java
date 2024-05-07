package com.laempacadora.domain.service;

import com.laempacadora.persistence.MesaRepository;
import com.laempacadora.persistence.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAll()
    {
        return mesaRepository.getAll();
    }

    public Optional<Mesa> getMesa(int idMesa)
    {
        return mesaRepository.getMesa(idMesa);
    }

    public Mesa save(Mesa mesa)
    {
        return mesaRepository.save(mesa);
    }

    public boolean delete(int idMesa)
    {
        return getMesa(idMesa).map(mesa -> {
            mesaRepository.delete(idMesa);
            return true;
        }).orElse(false);
    }

    public Mesa update(Mesa mesa)
    {
        return mesaRepository.update(mesa);
    }

    public boolean exists(int idMesa)
    {
        boolean exists = false;
        if(mesaRepository.getMesa(idMesa).isPresent())
        {
            exists = true;
        }
        return exists;
    }
}
