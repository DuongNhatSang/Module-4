package com.codegym.service;

import com.codegym.model.AttachService;

import java.util.List;

public interface IAttachServiceService {
    List<AttachService> findAll();
    AttachService findById(int id);
}
