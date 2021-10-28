package com.codegym.controller;

import com.codegym.model.DiaChiLienLac;
import com.codegym.model.ToKhaiYTe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToKhaiYTeController {
    @GetMapping("/home")
    public String showForm(Model model){
        model.addAttribute("toKhaiYTe",new ToKhaiYTe());
        model.addAttribute("diaChiLienLac",new DiaChiLienLac());
        return "home";
    }
    @PostMapping("/home")
    public String createToKhaiYTe(@RequestParam(required = false) DiaChiLienLac diaChiLienLac){
        DiaChiLienLac diaChiLienLac1 = diaChiLienLac;
        return "home";
    }
}
