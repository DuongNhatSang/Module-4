package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogServiceImpl;
import com.codegym.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("")
    public ResponseEntity<?> findAllBlog(@RequestParam int page) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page,2));
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<?> findAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/ofcategory/{id}")
    public ResponseEntity<?> findAllBlogOfCategory(@PathVariable int id) {
        List<Blog> blogList = blogService.findByCategory_Id(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable int id) {
        blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
