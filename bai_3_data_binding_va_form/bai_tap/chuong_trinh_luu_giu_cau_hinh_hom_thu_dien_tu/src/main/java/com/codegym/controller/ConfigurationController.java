package com.codegym.controller;

import com.codegym.model.Configuration;
import com.codegym.service.ConfigurationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConfigurationController {
    @Autowired
    private ConfigurationServiceImpl configurationService;

    @GetMapping("/update")
    public String updateConfiguration(Model model){
        Configuration configuration = configurationService.getConfiguration(1);
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        model.addAttribute("configuration",configuration);
        return "update";
    }
    @PostMapping("/update")
    public String saveConfiguration(@ModelAttribute Configuration configuration, Model model){
        configurationService.updateConfiguration(configuration);
        Configuration configuration1 = configurationService.getConfiguration(1);
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        model.addAttribute("configuration",configuration1);
        return "update";
    }
}
