package com.portfolio.lastry.Service;

import com.portfolio.lastry.Entity.HyS;
import com.portfolio.lastry.Repository.IHySRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpHySService {
    @Autowired
    IHySRep iHySRep;

    public List<HyS> list(){
        return iHySRep.findAll();
    }

    public Optional<HyS> getOne(int id){
        return iHySRep.findById(id);
    }

    public Optional<HyS> getByName(String name){
        return iHySRep.findByName(name);
    }

    public void save(HyS skill){
        iHySRep.save(skill);
    }

    public void delete(int id){
        iHySRep.deleteById(id);
    }

    public boolean existsById(int id){
        return iHySRep.existsById(id);
    }

    public boolean existsByName(String name){
        return iHySRep.existsByName(name);
    }
}
