package com.portfolio.lastry.Service;

import com.portfolio.lastry.Entity.Experiencia;
import com.portfolio.lastry.Entity.Projects;
import com.portfolio.lastry.Repository.IProjectsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpProjectsService {
    @Autowired
    IProjectsRep iProjectsRep;

    public List<Projects> list() {return iProjectsRep.findAll();}

    public Optional<Projects> getOne(int id) {
        return iProjectsRep.findById(id);
    }

    public Optional<Projects> getByTitleP(String title) {
        return iProjectsRep.findByTitle(title);
    }

    public void save(Projects project) {
        iProjectsRep.save(project);
    }

    public void delete(int id) {
        iProjectsRep.deleteById(id);
    }

    public boolean existsById(int id) {
        return iProjectsRep.existsById(id);
    }

    public boolean existsByTitleP(String title) {
        return iProjectsRep.existsByTitle(title);
    }
}
