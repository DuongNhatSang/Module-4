package com.codegym.service.impl;

import com.codegym.model.RentalBook;
import com.codegym.repository.IRentalBookRepository;
import com.codegym.service.IRentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentalBookServiceImpl implements IRentalBookService {
    @Autowired
    IRentalBookRepository rentalBookRepository;
    @Override
    public List<RentalBook> finfAll() {
        return rentalBookRepository.findAll();
    }

    @Override
    public void delete(RentalBook rentalBook) {
        rentalBookRepository.delete(rentalBook);
    }

    @Override
    public void save(RentalBook rentalBook) {
        rentalBookRepository.save(rentalBook);
    }
}
