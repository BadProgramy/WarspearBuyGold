package article.example.demo.controller;

import article.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warspear")
public class FirstMainController {
    @Autowired
    private OrderService service;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("orders", service.getLastTenOrderInSorted());
        return "firstMain";
    }
}
