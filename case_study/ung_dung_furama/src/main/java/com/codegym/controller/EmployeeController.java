package com.codegym.controller;

import com.codegym.dto.CustomerCreateDTO;
import com.codegym.dto.CustomerDTO;
import com.codegym.dto.EmployeeCreateDTO;
import com.codegym.dto.EmployeeDTO;
import com.codegym.model.*;
import com.codegym.service.IContractService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    IContractService contractService;

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

    @GetMapping("")
    public String showListEmpl(Model model, @PageableDefault(value = 3,sort = "employeeId",direction = Sort.Direction.ASC) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "/employee/list";
    }
//    @PostMapping("/create")
//    public String saveEmployee(Model model,@ModelAttribute EmployeeDTO employeeDTO,
//                               @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC)Pageable pageable){
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDTO,employee);
//        employeeService.save(employee);
//        Page<Employee> employees = employeeService.findAll(pageable);
//
//        model.addAttribute("employees", employees);
//        model.addAttribute("employeeDTO", new EmployeeDTO());
//        return "/employee/list";
//    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createEmployee(@RequestBody @Validated EmployeeCreateDTO employeeCreateDTO,
                                           BindingResult bindingResult) {
        Map<String,String> errors=  new LinkedHashMap<>();
        for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {

            errors.put(bindingResult.getFieldErrors().get(i).getField(),bindingResult.getFieldErrors().get(i).getDefaultMessage());

        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Trạng thái 400
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeCreateDTO,employee);
        employee.setPosition(positionService.findById(employeeCreateDTO.getPosition()));
        employee.setDivision(divisionService.findById(employeeCreateDTO.getDivision()));
        employee.setEducation(educationService.findById(employeeCreateDTO.getEducation()));
        employeeService.save(employee);

        return new ResponseEntity<>(HttpStatus.OK); //Trạng thái 200.
    }



    @PostMapping("/delete")
    public String deleteEmployee(Model model,@RequestParam long id,
                                 @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC)Pageable pageable){
        Employee employee = employeeService.findById(id);
        contractService.deleteContractByEmpl(id);
        employeeService.delete(employee);
        Page<Employee> employees = employeeService.findAll(pageable);

        model.addAttribute("employees", employees);
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "/employee/list";

    }

    @GetMapping("/edit/{id}")
    public String showEditEmployee(Model model,@PathVariable long id){
        Employee employee = employeeService.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);

        model.addAttribute("employeeDTO",employeeDTO);
        return "/employee/edit";
    }
    @PostMapping("/edit")
    public ModelAndView saveEditEmployee(@ModelAttribute @Validated EmployeeDTO employeeDTO, BindingResult bindingResult,
                                         @PageableDefault(value = 5,sort = "employeeId",direction = Sort.Direction.ASC)Pageable pageable){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/employee/edit");

            return modelAndView;
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO,employee);
            employeeService.save(employee);
            Page<Employee> employees = employeeService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/employee/list");
            modelAndView.addObject("employees", employees);
            modelAndView.addObject("employeeDTO", new EmployeeDTO());

            return modelAndView;
        }

    }
}
