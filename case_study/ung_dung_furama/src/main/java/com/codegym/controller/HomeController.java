package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerDTO;
import com.codegym.model.CustomerType;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.CustomerTypeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerTypeServiceImpl customerTypeService;
    @GetMapping("/home")
    public String showList() {
        return "/home";
    }



}
