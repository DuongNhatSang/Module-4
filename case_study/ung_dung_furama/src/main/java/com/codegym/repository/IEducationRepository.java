package com.codegym.repository;

import com.codegym.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<Education,Long> {
}
