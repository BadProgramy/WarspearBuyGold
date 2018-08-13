package article.example.demo.controller;

import article.example.demo.model.User;
import article.example.demo.service.OrderService;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/warspear")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    private User user;

    @RequestMapping(value = "/orders")
    public String ordersPage(Model model) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        model.addAttribute("orders", orderService.getOrdersByUser(user));
        return "order";
    }

    @RequestMapping(value = "/delete/{orderId}",method = RequestMethod.GET)
    public String delete(@PathVariable("orderId") long orderId, Model model) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        orderService.delete(orderId);
        model.addAttribute("user",user);
        model.addAttribute("orders",orderService.getOrdersByUser(user));
        return "order";
    }
}
