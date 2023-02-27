package com.portfolio.lastry.Security.Service;

import com.portfolio.lastry.Security.Entity.Rol;
import com.portfolio.lastry.Security.Enums.RolNombre;
import com.portfolio.lastry.Security.Repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        iRolRepository.save(rol);
    }
}
