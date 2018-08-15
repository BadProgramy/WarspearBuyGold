package article.example.demo.controller;

import article.example.demo.model.Order;
import article.example.demo.model.Status;
import article.example.demo.model.User;
import article.example.demo.service.OrderService;
import article.example.demo.service.OutbidService;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.time.LocalDate;

@Controller
@RequestMapping("/warspear")
public class BuyGoldController {

    @Autowired
    private UserService userService;

    @Autowired
    private OutbidService outbidService;

    @Autowired
    private OrderService orderService;

    private static final String BUY_GOLD_GORY = "Заказ у гор";
    private static final double MULTIPLICATION_GOLD = 0.002;

    private User user;

    @RequestMapping(value = "/buyGold")
    public String buyGold(Model model) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        return "buyGold";
    }


    @RequestMapping(value = "/buyGoldGory")
    public String buyGoldAtGory(Model model) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        model.addAttribute("outbid",outbidService.getOutbid("Gory"));
        model.addAttribute("order", new Order());
        return "buyGoldAtGory";
    }

    @RequestMapping(value = "/buyGoldGory/submit", method = RequestMethod.POST)
    public String buyGoldAtGorySubmit(@ModelAttribute Order order, Model model) throws SQLException {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        order.setDescription(String.valueOf(BUY_GOLD_GORY));
        order.setStatus(Status.IDET_VYSTAVLENIE_SCHETA);
        order.setDate(LocalDate.now());
        order.setCost(String.valueOf(Double.valueOf(order.getGold())*MULTIPLICATION_GOLD));
        order.setUser(user);
        orderService.save(order);
        model.addAttribute("user",user);
        model.addAttribute("orders",orderService.getOrdersByUser(user));
        return "redirect:../orders";
    }
}
