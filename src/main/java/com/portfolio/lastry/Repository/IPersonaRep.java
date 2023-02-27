package com.portfolio.lastry.Repository;

import com.portfolio.lastry.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRep extends JpaRepository<Persona, Long> {

}
