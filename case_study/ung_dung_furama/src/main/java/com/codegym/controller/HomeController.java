package com.codegym.controller;

import com.codegym.dto.*;
import com.codegym.model.*;
import com.codegym.service.*;
import com.codegym.service.impl.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
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
    @Autowired
    ContractServiceImpl contractService;
    @Autowired
    IAttachServiceService attachServiceService;
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
    @ModelAttribute("contractList")
    public List<Contract> contractList() {
        return contractService.findAll();
    }
    @ModelAttribute("attachServiceList")
    public List<AttachService> attachServiceList() {
        return attachServiceService.findAll();
    }
    @ModelAttribute("contractDetailCreateDTO")
    public ContractDetailCreateDTO contractDetailCreateDTO(){
        return new ContractDetailCreateDTO();
    }

    @GetMapping("home")
    public String showList(Model model,@PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC) Pageable pageable) {

        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("serviceDTO", new ServiceDTO());


        List<CustomerUsingService> customerUsingServicePage = customerService.getListCustomerUsing();
        model.addAttribute("customerUsingServicePage", customerUsingServicePage);


        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("contractDTO", new ContractDTO());
        model.addAttribute("contractDetail", new ContractDetail());


        return "/home";
    }
    @GetMapping("/home/detail/{id}")
    public ResponseEntity<?> editPhones(@PathVariable int id) {
        List<ContractDetailDTO> contractDetailList = contractDetailService.findByContractId(id);
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
    @PostMapping("/home/contractdetailsave")
    public String saveContractDetail(Model model,@ModelAttribute ContractDetailCreateDTO contractDetailCreateDTO){
        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("serviceDTO", new ServiceDTO());
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailCreateDTO,contractDetail);
        contractDetail.setContract(contractService.findById(contractDetailCreateDTO.getContract()));
        contractDetail.setAttachService(attachServiceService.findById(contractDetailCreateDTO.getAttachService()));

        List<CustomerUsingService> customerUsingServicePage = customerService.getListCustomerUsing();
        model.addAttribute("customerUsingServicePage", customerUsingServicePage);



        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("contractDTO", new ContractDTO());
        model.addAttribute("contractDetail", new ContractDetail());
        contractDetailService.save(contractDetail);
        return "/home";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/addUser")
    public String addUser(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("userDTO",new UserDTO());
        model.addAttribute("roleList",roleList);
        return "/user";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserDTO userDTO){
        User user = new User();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(password);
        BeanUtils.copyProperties(userDTO,user);
        userService.save(user);
        User user1 = userService.findByUserName(user.getUserName());
        Employee employee = employeeService.findById(userDTO.getEmployee());
        if(employee.getPosition().getPositionId() != 5 && employee.getPosition().getPositionId() != 6){
            userService.addUserRole(user1.getId(),1);
        }else {
            userService.addUserRole2(user1.getId(),1,2);
        }
        employee.setUser(user1);
        employeeService.save(employee);

        return "/home";
    }



}
