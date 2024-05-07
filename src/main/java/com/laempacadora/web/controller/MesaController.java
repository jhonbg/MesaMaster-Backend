package com.laempacadora.web.controller;

import com.laempacadora.domain.service.MesaService;
import com.laempacadora.persistence.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping("/all")
    public ResponseEntity<List<Mesa>> getAll()
    {
        return new ResponseEntity<>(mesaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mesa>> getMesa(@PathVariable("id") int idMesa)
    {
        return new ResponseEntity<>(mesaService.getMesa(idMesa),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Mesa> save(@RequestBody Mesa mesa)
    {
        if(mesaService.exists(mesa.getIdMesa()) == false)
        {
            return new ResponseEntity<>(mesaService.save(mesa),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idMesa)
    {
        return new ResponseEntity<>(mesaService.delete(idMesa),HttpStatus.ACCEPTED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mesa> update(@RequestBody Mesa mesa)
    {
        if(mesaService.exists(mesa.getIdMesa()) == true)
        {
            return new ResponseEntity<>(mesaService.update(mesa),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
