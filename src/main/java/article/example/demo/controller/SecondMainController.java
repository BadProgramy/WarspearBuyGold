package article.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/warspear")
public class SecondMainController {


    @RequestMapping(value = "/profile")
    public String getSecondMain() {
        return "secondMain";
    }
}
