package com.codegym.controller;


import com.codegym.model.ToKhaiYTe;
import com.codegym.service.ToKhaiYTeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToKhaiYTeController {
    private ToKhaiYTeServiceImpl toKhaiYTeService = new ToKhaiYTeServiceImpl();
    @GetMapping("/home")
    public String showForm(Model model){
        model.addAttribute("toKhaiYTe",new ToKhaiYTe());
        return "/home";
    }
    @PostMapping("/home")
    public String createToKhaiYTe(ToKhaiYTe toKhaiYTe, RedirectAttributes redirectAttributes){
        toKhaiYTe.setId((int) (Math.random() * 10000));
        toKhaiYTeService.createToKhaiYTe(toKhaiYTe);
        redirectAttributes.addFlashAttribute("success","Ok");
        return "redirect:/list";
    }
    @RequestMapping("/list")
    public String showList(Model model){
        List<ToKhaiYTe> toKhaiYTeList = toKhaiYTeService.getListToKhaiYTe();
        model.addAttribute("toKhaiYTeList",toKhaiYTeList);
        return "/list";
    }
}
