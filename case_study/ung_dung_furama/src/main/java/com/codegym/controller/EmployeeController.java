package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.impl.DivisionServiceImpl;
import com.codegym.service.impl.EducationServiceImpl;
import com.codegym.service.impl.EmployeeServiceImpl;
import com.codegym.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    PositionServiceImpl positionService;
    @Autowired
    DivisionServiceImpl divisionService;
    @Autowired
    EducationServiceImpl educationService;

    @GetMapping("")
    public String showListCus(Model model, @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Education> educationList = educationService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employees", employees);
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "/employee/list";
    }
}
