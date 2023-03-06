package com.portfolio.lastry.Repository;

import com.portfolio.lastry.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProjectsRep extends JpaRepository<Projects, Integer> {
    public Optional<Projects> findByTitle(String title);
    public boolean existsByTitle(String title);
}
