package com.codegym.repository;

import com.codegym.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Long> {
}
