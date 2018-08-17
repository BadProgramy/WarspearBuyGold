package article.example.demo.controller;

import article.example.demo.model.User;
import article.example.demo.service.OrderService;
import article.example.demo.service.OutbidService;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warspear")
public class SaleGoldController {
    @Autowired
    private UserService userService;

    @Autowired
    private OutbidService outbidService;

    @Autowired
    private OrderService orderService;

    private static final String SALE_GOLD_GORY = "Продажа у гор";
    private static final double MULTIPLICATION_GOLD = 0.002;

    private User user;

    @RequestMapping(value = "/saleGold")
    public String buyGold(Model model) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        return "technicalWorkPageSale";
    }
}
