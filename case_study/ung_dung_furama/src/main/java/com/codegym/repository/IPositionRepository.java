package com.codegym.repository;


import com.codegym.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Long> {
}
