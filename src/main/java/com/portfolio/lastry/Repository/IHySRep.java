package com.portfolio.lastry.Repository;

import com.portfolio.lastry.Entity.HyS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHySRep extends JpaRepository<HyS, Integer> {
    Optional<HyS> findByName(String name);

    public boolean existsByName(String name);
}
