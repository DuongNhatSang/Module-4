package com.codegym.controller;

import com.codegym.dto.*;
import com.codegym.model.*;
import com.codegym.service.*;
import com.codegym.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducationService educationService;
    @Autowired
    IServiceTypeService serviceTypeService;
    @Autowired
    IRentTypeService rentTypeService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping("home")
    public String showList(Model model,@PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC) Pageable pageable) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<Education> educationList = educationService.findAll();
        model.addAttribute("serviceDTO", new ServiceDTO());
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<Customer> customerList = customerService.findAllList();
        List<Employee> employeeList = employeeService.findAllList();
        List<Service> serviceList = serviceService.findAllList();

        List<CustomerUsingService> customerUsingServicePage = customerService.getListCustomerUsing();
        model.addAttribute("customerUsingServicePage", customerUsingServicePage);


        model.addAttribute("customerList", customerList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("contractDTO", new ContractDTO());

        return "/home";
    }
    @GetMapping("/home/detail/{id}")
    public ResponseEntity<?> editPhones(@PathVariable int id) {
        List<ContractDetail> contractDetailList = contractDetailService.findByContractId(id);
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }



}
