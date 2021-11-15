package com.codegym.controller;

import com.codegym.dto.ContractDTO;
import com.codegym.dto.CustomerDTO;
import com.codegym.dto.EmployeeDTO;
import com.codegym.dto.ServiceDTO;
import com.codegym.model.*;
import com.codegym.service.impl.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("contract")
public class ContractController {
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
    @Autowired
    ContractServiceImpl contractService;

    @PostMapping("/create")
    public String saveContract(Model model, @ModelAttribute ContractDTO contractDTO){
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO,contract);
        contractService.save(contract);
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
}
