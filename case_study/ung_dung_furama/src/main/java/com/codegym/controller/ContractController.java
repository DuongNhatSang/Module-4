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
//    public String saveContract(Model model, @ModelAttribute ContractDTO contractDTO){
//
//
//        Contract contract = new Contract();
//        BeanUtils.copyProperties(contractDTO,contract);
//        contractService.save(contract);
//        model.addAttribute("customerDTO", new CustomerDTO());
//        model.addAttribute("serviceDTO", new ServiceDTO());
//        model.addAttribute("employeeDTO", new EmployeeDTO());
//
//
//        return "/home";
//
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createContract(@RequestBody @Validated ContractCreateDTO contractCreateDTO,
                                            BindingResult bindingResult) {
        Map<String,String> errors = new LinkedHashMap<>();
        for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {

            errors.put(bindingResult.getFieldErrors().get(i).getField(),bindingResult.getFieldErrors().get(i).getDefaultMessage());

        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Trạng thái 400
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractCreateDTO,contract);
        contract.setCustomer(customerService.findById(contractCreateDTO.getCustomer()));
        contract.setService(serviceService.findById(contractCreateDTO.getService()));
        contract.setEmployee(employeeService.findById(contractCreateDTO.getEmployee()));
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK); //Trạng thái 200.
    }
}
