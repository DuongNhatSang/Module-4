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

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerTypeServiceImpl customerTypeService;
    @GetMapping("")
    public String showListCus(Model model, @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC) Pageable pageable){
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }


    @PostMapping("/create")
    public String saveCustomer(Model model,@ModelAttribute CustomerDTO customerDTO,
                               @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditCustomer(Model model,@PathVariable long id){
        Customer customer = customerService.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO",customerDTO);
        return "/customer/edit";
    }
    @PostMapping("/edit")
    public String saveEditCustomer(Model model,@ModelAttribute CustomerDTO customerDTO,
                                   @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }
    @PostMapping("/delete")
    public String deleteCustomer(Model model,@RequestParam long id,
                                 @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){
        customerService.delete(id);
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }
}
