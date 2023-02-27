package com.portfolio.lastry.Service;

import com.portfolio.lastry.Repository.IPersonaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.lastry.Entity.Persona;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IPersonaRep iPersonaRep;

    public List<Persona> list() {
        return iPersonaRep.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return iPersonaRep.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return iPersonaRep.findByNombre(nombre);
    }

    public void save(Persona persona) {
        iPersonaRep.save(persona);
    }

    public void delete(int id) {
        iPersonaRep.deleteById(id);
    }

    public boolean existsById(int id) {
        return iPersonaRep.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iPersonaRep.existsByNombre(nombre);
    }

}
