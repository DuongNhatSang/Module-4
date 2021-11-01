package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
            return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message", "Created new blog successfully !");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable int id , Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/edit";
    }
    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("message", "Created new product successfully !");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id,Model model) {
        blogService.delete(id);
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/index";
    }
    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable int id , Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/view";
    }
}
