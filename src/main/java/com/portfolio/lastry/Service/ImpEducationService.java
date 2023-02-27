package com.portfolio.lastry.Service;

import com.portfolio.lastry.Entity.Education;
import com.portfolio.lastry.Repository.IEducationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpEducationService {
    @Autowired
    IEducationRep  iEducationRep;

    public List<Education> list() {
        return iEducationRep.findAll();
    }

    public Optional<Education> getOne(int id) {
        return iEducationRep.findById(id);
    }

    public Optional<Education> getByTitleEdu(String titleEd) {
        return iEducationRep.findByTitleEd(titleEd);
    }

    public void save(Education education) {
        iEducationRep.save(education);
    }

    public void delete(int id) {
        iEducationRep.deleteById(id);
    }

    public boolean existsById(int id) {
        return iEducationRep.existsById(id);
    }

    public boolean existsByTitleEd(String titleEd){
        return iEducationRep.existsByTitleEd(titleEd);
    }
}
