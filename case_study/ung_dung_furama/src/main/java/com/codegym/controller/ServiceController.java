package com.codegym.controller;

import com.codegym.dto.*;
import com.codegym.model.*;

import com.codegym.service.impl.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerTypeServiceImpl customerTypeService;
    @Autowired
    PositionServiceImpl positionService;
    @Autowired
    DivisionServiceImpl divisionService;
    @Autowired
    EducationServiceImpl educationService;
    @Autowired
    ServiceTypeServiceImpl serviceTypeService;
    @Autowired
    RentTypeServiceImpl rentTypeService;
    @Autowired
    ServiceServiceImpl serviceService;
    @Autowired
    EmployeeServiceImpl employeeService;
    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return customerTypeService.findAll();
    }
    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return positionService.findAll();
    }
    @ModelAttribute("divisionList")
    public List<Division> divisionList() {
        return divisionService.findAll();
    }
    @ModelAttribute("educationList")
    public List<Education> educationList() {
        return educationService.findAll();
    }
    @ModelAttribute("serviceTypeList")
    public List<ServiceType> serviceTypeList() {
        return serviceTypeService.findAll();
    }
    @ModelAttribute("rentTypeList")
    public List<RentType> rentTypeList() {
        return rentTypeService.findAll();
    }
    @ModelAttribute("customerList")
    public List<Customer> customerList() {
        return customerService.findAllList();
    }
    @ModelAttribute("employeeList")
    public List<Employee> employeeList() {
        return employeeService.findAllList();
    }
    @ModelAttribute("serviceList")
    public List<Service> serviceList() {
        return serviceService.findAllList();
    }
    @ModelAttribute("customerDTO")
    public CustomerDTO customerDTO() {
        return  new CustomerDTO();
    }
    @ModelAttribute("employeeDTO")
    public EmployeeDTO employeeDTO() {
        return  new EmployeeDTO();
    }


//    @PostMapping("/create")
//    public String saveService(Model model, @ModelAttribute ServiceDTO serviceDTO){
//        Service service = new Service();
//        BeanUtils.copyProperties(serviceDTO,service);
//        serviceService.save(service);
//
//
//        return "/home";
//
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody @Validated ServiceDTO serviceDTO,
                                            BindingResult bindingResult) {
        Map<String,String> errors = new LinkedHashMap<>();
        for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {

            errors.put(bindingResult.getFieldErrors().get(i).getField(),bindingResult.getFieldErrors().get(i).getDefaultMessage());

        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Trạng thái 400
        }

        Service service = new Service();
        BeanUtils.copyProperties(serviceDTO,service);
        service.setRentType(rentTypeService.findById(serviceDTO.getRentType()));
        service.setServiceType(serviceTypeService.findById(serviceDTO.getServiceType()));
        serviceService.save(service);
        return new ResponseEntity<>(HttpStatus.OK); //Trạng thái 200.
    }
}
