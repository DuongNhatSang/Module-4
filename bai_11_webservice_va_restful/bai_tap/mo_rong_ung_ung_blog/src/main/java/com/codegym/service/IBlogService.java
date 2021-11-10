package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> search(String category,String title,Pageable pageable);
    List<Blog> findByCategory_Id(int id);
}
