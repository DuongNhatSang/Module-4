package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.impl.DivisionServiceImpl;
import com.codegym.service.impl.EducationServiceImpl;
import com.codegym.service.impl.EmployeeServiceImpl;
import com.codegym.service.impl.PositionServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showListEmpl(Model model, @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC) Pageable pageable){
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
    @PostMapping("/create")
    public String saveEmployee(Model model,@ModelAttribute EmployeeDTO employeeDTO,
                               @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC)Pageable pageable){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeService.save(employee);
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
    @PostMapping("/delete")
    public String deleteEmployee(Model model,@RequestParam long id,
                                 @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC)Pageable pageable){
        employeeService.delete(id);
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

    @GetMapping("/edit/{id}")
    public String showEditEmployee(Model model,@PathVariable long id){
        Employee employee = employeeService.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Education> educationList = educationService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employeeDTO",employeeDTO);
        return "/employee/edit";
    }
    @PostMapping("/edit")
    public String saveEditEmployee(Model model,@ModelAttribute EmployeeDTO employeeDTO,
                                   @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeService.save(employee);
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
