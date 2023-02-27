package com.portfolio.lastry.Security.Repository;

import com.portfolio.lastry.Security.Entity.Rol;
import com.portfolio.lastry.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
