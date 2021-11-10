package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogServiceImpl;
import com.codegym.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    CategoryServiceImpl categoryService;
    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 1,sort = "date",direction = Sort.Direction.ASC)Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String title,
                           @RequestParam(required = false, defaultValue = "") String category ) {
        Page<Blog> blogList = blogService.search(category,title,pageable);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("title", title);
        model.addAttribute("category", category);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categoryList", categoryList);
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
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog",blog);

        return "/edit";
    }
    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute Blog blog,@PageableDefault(value = 3,sort = "id",direction = Sort.Direction.ASC)Pageable pageable) {
        blogService.save(blog);
        Page<Blog> blogList = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("message", "Created new product successfully !");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id,Model model,@PageableDefault(value = 3,sort = "id",direction = Sort.Direction.ASC)Pageable pageable) {
        blogService.delete(id);
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("blogList", blogList);
        return "/index";
    }
    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable int id , Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/view";
    }
//    @GetMapping("/search")
//    public String searchBlog(Model model,@RequestParam(required = false, defaultValue = "") String title,String category , @PageableDefault(value = 3,sort = "date",direction = Sort.Direction.ASC)Pageable pageable){
//        Page<Blog> blogList = blogService.search(category,title,pageable);
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("blogList", blogList);
//
//
//        return "/index";
//    }
}
