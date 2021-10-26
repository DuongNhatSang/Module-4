package codegym.vn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping
    public String getHome(){
        return "home";
    }
    @PostMapping
    public String caculator(Model model, @RequestParam(required = false) double numberone, double numbertwo,String operator){
        double result = 0;
        if(operator.equals("Addition(+)")){
            result = numberone + numbertwo;
            model.addAttribute("result",result);
        }
        if(operator.equals("Subtraction(-)")){
            result = numberone - numbertwo;
            model.addAttribute("result",result);
        }
        if(operator.equals("Multiplication(X)")){
            result = numberone * numbertwo;
            model.addAttribute("result",result);
        }
        if(operator.equals("Division(/)")){
            if(numbertwo != 0) {
                result = numberone / numbertwo;
                model.addAttribute("result", result);
            }else {
                String err = "Mẫu số phải khác 0";
                model.addAttribute("result",err);
            }
        }
        model.addAttribute("numberone",numberone);
        model.addAttribute("numbertwo",numbertwo);
        return "home";
    }
}
