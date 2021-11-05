package com.codegym.service;

import com.codegym.model.RentalBook;

import java.util.List;

public interface IRentalBookService {
    List<RentalBook> finfAll();
    void delete(RentalBook rentalBook);
    void save(RentalBook rentalBook);
}
