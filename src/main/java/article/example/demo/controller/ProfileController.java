package article.example.demo.controller;


import article.example.demo.model.User;
import article.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warspear")
public class ProfileController {

    @Autowired
    private UserService userService;

    private User user;

    @RequestMapping(value = "/profile")
    public String profile(Model model) {
        if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = userService.findUserByName(authentication.getName());
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = "/profile/submit")
    public String profileSubmitSaving(@ModelAttribute User user) {
        if (this.user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            this.user = userService.findUserByName(authentication.getName());
        }
        this.user.update(user);
        userService.save(this.user);
        return "profile";
    }
}
