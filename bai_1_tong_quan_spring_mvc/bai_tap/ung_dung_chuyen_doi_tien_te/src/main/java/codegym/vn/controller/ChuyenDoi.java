package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChuyenDoi {
    @GetMapping("/home")
    public String getHome(){
        return "home";
    }
    @PostMapping("/home")
    public String greeting(@RequestParam double tigia, double luongusd, Model model) {
        double ketQua = tigia * luongusd;
        model.addAttribute("tigia", tigia);
        model.addAttribute("luongusd", luongusd);
        model.addAttribute("ketqua", ketQua);
        return "home";
    }
}
