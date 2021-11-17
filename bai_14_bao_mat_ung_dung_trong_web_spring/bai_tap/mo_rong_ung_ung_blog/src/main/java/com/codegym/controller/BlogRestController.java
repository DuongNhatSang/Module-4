package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogServiceImpl;
import com.codegym.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    CategoryServiceImpl categoryService;

    @ModelAttribute("categoryList")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

        @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5,sort = "date",direction = Sort.Direction.ASC) Pageable pageable,
                                 @RequestParam(required = false, defaultValue = "") String title,
                                 @RequestParam(required = false, defaultValue = "") String category ) {
        Page<Blog> blogList = blogService.search(category,title,pageable);

        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("title", title);
        modelAndView.addObject("category", category);
        return modelAndView;
    }
    @GetMapping("/more")
    public ResponseEntity<?> allPhones(@RequestParam int page) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page,1));
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> searchBlog(
            @RequestParam(required = false, defaultValue = "") String title,
            @RequestParam(required = false, defaultValue = "") String category) {
        List<Blog> blogPage = blogService.searchBlog(category, title);

        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }


}
