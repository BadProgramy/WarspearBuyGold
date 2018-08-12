package article.example.demo.controller;

import article.example.demo.model.Order;
import article.example.demo.model.Outbid;
import article.example.demo.model.User;
import article.example.demo.service.OrderService;
import article.example.demo.service.OutbidService;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.event.AuthenticationFailureProxyUntrustedEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Controller
@RequestMapping("/warspear")
public class SecondMainController {
    @Autowired
    private UserService userService;

    private User user;


    @RequestMapping(value = "/main")
    public String main(Model model) {
        if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        return "secondMain";
    }
}
