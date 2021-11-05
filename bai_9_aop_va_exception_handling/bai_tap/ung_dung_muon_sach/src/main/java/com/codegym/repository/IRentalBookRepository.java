package com.codegym.repository;

import com.codegym.model.RentalBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentalBookRepository extends JpaRepository<RentalBook,Long> {
}
