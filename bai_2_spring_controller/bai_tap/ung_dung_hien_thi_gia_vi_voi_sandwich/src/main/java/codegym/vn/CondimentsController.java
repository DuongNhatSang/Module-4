package codegym.vn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentsController {
    @GetMapping
    public String getHome(){
        return "home333";
    }
    @PostMapping
    public String saveCondiments(Model model, @RequestParam(required = false,defaultValue = "") String lettuce,
                                 String tomato,String mustard,String sprouts){
        List<String> strings = new ArrayList<>();
        if(lettuce != ""){
            strings.add(lettuce);
        }
        if(tomato != ""){
            strings.add(tomato);
        }
        if(mustard != ""){
            strings.add(mustard);
        }
        if(sprouts != ""){
            strings.add(sprouts);
        }
        model.addAttribute("strings",strings);
        return "result";
    }
}
