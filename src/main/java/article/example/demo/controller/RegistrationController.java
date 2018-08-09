package article.example.demo.controller;

import article.example.demo.model.Role;
import article.example.demo.model.User;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/warspear")
public class RegistrationController {

    @Autowired
    private UserService userService;


    @RequestMapping("/registration/submit")
    public String addUser(@ModelAttribute User user){
        //user.setActive(true);
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);
        user.setRole(roles);
        //user.setId(1L)2;
        userService.save(user);
        return "redirect:../";
    }

    @RequestMapping("/registration")
    public String registrationPage(Model model) throws SQLException {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    //@RequestMapping(value = "login/submit")
    public String loginSubmit() {
        //Тут уже заполнение шаблона secondMain
        return "secondMain";
    }
}
