package com.portfolio.lastry.Repository;

import com.portfolio.lastry.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRep extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByTitleE(String titleE);
    public boolean existsByTitleE(String titleE);
}
