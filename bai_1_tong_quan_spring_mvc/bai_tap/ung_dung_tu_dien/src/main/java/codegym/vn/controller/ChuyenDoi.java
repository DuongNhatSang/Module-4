package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChuyenDoi {
    @GetMapping
    public String getList(){
        return "home";
    }
    @PostMapping
    public String getResult(@RequestParam String string, Model model){
        String[] strings = {"hello","blue","red","black"};
        String[] results = {"xin chào","xanh","đỏ","đen"};
        String result = "Không có kết quả";
        for (int i = 0; i < strings.length; i++) {
            if(string.equals(strings[i])){
                result = results[i];
            }
        }
        model.addAttribute("string", string);
        model.addAttribute("result", result);
        return "home";
    }
}
