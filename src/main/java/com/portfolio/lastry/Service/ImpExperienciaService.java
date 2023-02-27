package com.portfolio.lastry.Service;

import com.portfolio.lastry.Entity.Experiencia;
import com.portfolio.lastry.Repository.IExperienciaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpExperienciaService {
    @Autowired
    IExperienciaRep iExperienciaRep;

    public List<Experiencia> list() {
        return iExperienciaRep.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return iExperienciaRep.findById(id);
    }

    public Optional<Experiencia> getByTitleE(String titleE) {
        return iExperienciaRep.findByTitleE(titleE);
    }

    public void save(Experiencia exp) {
        iExperienciaRep.save(exp);
    }

    public void delete(int id) {
        iExperienciaRep.deleteById(id);
    }

    public boolean existsById(int id) {
        return iExperienciaRep.existsById(id);
    }

    public boolean existsByTitleE(String titleE) {
        return iExperienciaRep.existsByTitleE(titleE);
    }
}
