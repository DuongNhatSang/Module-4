package com.codegym.controller;

import com.codegym.dto.CustomerCreateDTO;
import com.codegym.model.Customer;
import com.codegym.dto.CustomerDTO;
import com.codegym.model.CustomerType;
import com.codegym.model.Service;
import com.codegym.service.IContractService;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.CustomerTypeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerTypeServiceImpl customerTypeService;
    @Autowired
    IContractService contractService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public String showListCus(Model model,
                              @RequestParam(required = false,defaultValue = "") String nameCus,
                              @RequestParam(required = false,defaultValue = "") String customerType,
                              @PageableDefault(value = 1,direction = Sort.Direction.ASC) Pageable pageable){
        Page<Customer> customers = customerService.search(nameCus,customerType,pageable);;
        model.addAttribute("customers", customers);
        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("nameCus", nameCus);
        model.addAttribute("customerType", customerType);


        return "/customer/list";
    }


//    @PostMapping("/create")
//    public String saveCustomer(Model model,@ModelAttribute CustomerDTO customerDTO,
//                               @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDTO,customer);
//        customerService.save(customer);
//        Page<Customer> customers = customerService.findAll(pageable);
//        model.addAttribute("customers", customers);
//        model.addAttribute("customerDTO", new CustomerDTO());
//        return "/customer/list";
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody @Validated CustomerCreateDTO customerCreateDTO,
                                           BindingResult bindingResult) {
        Map<String,String> errors = new LinkedHashMap<>();
        for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {

                errors.put(bindingResult.getFieldErrors().get(i).getField(),bindingResult.getFieldErrors().get(i).getDefaultMessage());

        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST); // Trạng thái 400
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerCreateDTO, customer);
        customer.setCustomerType(customerTypeService.findById(customerCreateDTO.getCustomerType()));
        this.customerService.save(customer);

        return new ResponseEntity<>(HttpStatus.OK); //Trạng thái 200.
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
    public ModelAndView saveEditCustomer(@ModelAttribute @Validated CustomerDTO customerDTO, BindingResult bindingResult,
                                   @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){

        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");

            return modelAndView;
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO,customer);
            customerService.save(customer);
            Page<Customer> customers = customerService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            modelAndView.addObject("customers", customers);
            modelAndView.addObject("customerDTO", new CustomerDTO());

            return modelAndView;
        }


    }
    @PostMapping("/delete")
    public String deleteCustomer(Model model,@RequestParam long id,
                                 @PageableDefault(value = 5,sort = "customerId",direction = Sort.Direction.ASC)Pageable pageable){

        Customer customer = customerService.findById(id);
        contractService.deleteContractByCus(id);
        customerService.delete(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }
    @PostMapping("/search")
    public String searchCustomer(Model model,
                                 @RequestParam(required = false,defaultValue = "") String nameCus,
                                 @RequestParam(required = false,defaultValue = "") String customerType,
                                 @PageableDefault(value = 1,direction = Sort.Direction.ASC)Pageable pageable){
        Page<Customer> customers = customerService.search(nameCus,customerType,pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }
}
