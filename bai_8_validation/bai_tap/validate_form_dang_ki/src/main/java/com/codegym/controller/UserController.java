package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.model.UserDTO;
import com.codegym.service.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping("")
    public String showList(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("userDTO", new UserDTO());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveBlog(@ModelAttribute @Validated UserDTO userDTO,
                                    BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            
            return modelAndView;
        }else {
            User user =new User();
            BeanUtils.copyProperties(userDTO,user);
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
    }

}
