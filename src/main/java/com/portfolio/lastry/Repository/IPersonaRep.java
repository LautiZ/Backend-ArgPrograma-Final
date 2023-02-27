package com.portfolio.lastry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portfolio.lastry.Entity.Persona;

import java.util.Optional;

@Repository
public interface IPersonaRep extends JpaRepository<Persona, Integer> {
    public Optional<Persona> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
