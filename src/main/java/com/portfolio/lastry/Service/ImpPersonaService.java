package com.portfolio.lastry.Service;

import com.portfolio.lastry.Entity.Persona;
import com.portfolio.lastry.Interface.IPersonaService;
import com.portfolio.lastry.Repository.IPersonaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRep iPersonaRep;

    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = iPersonaRep.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRep.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRep.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRep.findById(id).orElse(null);
        return persona;
    }
}
