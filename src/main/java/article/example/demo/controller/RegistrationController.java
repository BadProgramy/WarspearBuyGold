package article.example.demo.controller;

import article.example.demo.model.Role;
import article.example.demo.model.User;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/warspear")
public class RegistrationController {

    private static final String URL_Activation_For_Send_Mail = "https://warspear-buy-gold.herokuapp.com/warspear/registration/activation/sendMail/userId/";
    private static final String URL_Controller = "registration/activation/sendMail/userId/{userId}";


    @Autowired
    private UserService userService;

    @Autowired
    private Sender sender;


    @RequestMapping("/registration/submit")
    public String addUser(@ModelAttribute User user) {
        String encodePass = new BCryptPasswordEncoder().encode(user.getPassword());
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);

        try {
            user.setRole(roles);
            user.setPassword(encodePass);
            user.setEnabled(false);
            userService.save(user);
            sender.send("Активация аккаунта",
                    "Здравствуйте, это письмо пришло автоматически при регистрации аккаунта на Warspear Buy Gold." +
                            "Ссылка для активации " +URL_Activation_For_Send_Mail + userService.findUserByName(user.getUsername()).getId(),
                    user.getUsername());
            return "redirect:../registration/activation";
        } catch (Exception ex) {
            userService.delete(user);
            return "redirect:../registration/error";
        }
        catch (Error error) {
            userService.delete(user);
            return "redirect:../registration/error";
        }
    }

    @RequestMapping("/registration/error")
    public String postRegistration() {
        return "errorInput";
    }

    @RequestMapping("/registration/activation")
    public String activationAccount() {
        return "sendMail";
    }

    //@RequestMapping("/registration/activation/sendMail/userId/{userId}")
    @RequestMapping(URL_Controller)
    public String activationByUrl(@PathVariable("userId") long userId) throws SQLException {
        User user = userService.findUserById(userId);
        user.setEnabled(true);
        userService.save(user);
        return "redirect:../../../successful/activation/user";
    }

    @RequestMapping("/registration/successful/activation/user")
    public String successActivation() {
        return "successActivationAccount";
    }

    @RequestMapping("/registration")
    public String registrationPage(Model model) {
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
