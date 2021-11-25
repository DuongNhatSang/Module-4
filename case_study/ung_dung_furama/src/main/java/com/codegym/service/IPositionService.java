package com.codegym.service;


import com.codegym.model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Position findById(long id);
}
