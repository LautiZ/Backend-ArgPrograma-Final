package com.portfolio.lastry.Repository;

import com.portfolio.lastry.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEducationRep extends JpaRepository<Education, Integer> {
    public Optional<Education> findByTitleEd(String titleEd);

    public boolean existsByTitleEd(String titleEd);
}
