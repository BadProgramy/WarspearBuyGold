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

    private static final String BUY_GOLD_GORY = "Покупка у гор";
    private static final String BUY_GOLD_YXI = "Покупка у ух";
    private static final double MULTIPLICATION_GOLD = 0.002;
    private static final String GORY = "Gory";
    private static final String YXI = "Yxi";

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
        model.addAttribute("outbid",outbidService.getOutbid(GORY));
        model.addAttribute("order", new Order());
        model.addAttribute("isOrderProcessing",orderService.isOrderProcessing(user));
        return "buyGoldAtGory";
    }

    @RequestMapping(value = "/buyGoldGory/submit", method = RequestMethod.POST)
    public String buyGoldAtGorySubmit(@ModelAttribute Order order, Model model) throws SQLException {
        return buyGoldAtFractionSubmit(BUY_GOLD_GORY,order,model);
    }


    @RequestMapping(value = "/buyGoldYxi")
    public String buyGoldAtYxi(Model model) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        model.addAttribute("outbid",outbidService.getOutbid(YXI));
        model.addAttribute("order", new Order());
        model.addAttribute("isOrderProcessing",orderService.isOrderProcessing(user));
        return "buyGoldAtYxi";
    }

    @RequestMapping(value = "/buyGoldYxi/submit", method = RequestMethod.POST)
    public String buyGoldAtYxiSubmit(@ModelAttribute Order order, Model model) throws SQLException {
       return buyGoldAtFractionSubmit(BUY_GOLD_YXI,order,model);
    }

    private String buyGoldAtFractionSubmit(String fraction, Order order, Model model) throws SQLException {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }

        if (orderService.isOrderProcessing(user)) {
            order.setDescription(String.valueOf(fraction));
            order.setStatus(Status.IDET_VYSTAVLENIE_SCHETA);
            order.setDate(LocalDate.now());
            order.setCost(String.valueOf(Double.valueOf(order.getGold()) * MULTIPLICATION_GOLD));
            order.setUser(user);
            orderService.save(order);
        }

        model.addAttribute("user",user);
        model.addAttribute("orders",orderService.getOrdersByUser(user));
        return "redirect:../orders";
    }
}
