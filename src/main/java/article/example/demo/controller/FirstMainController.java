package article.example.demo.controller;

import article.example.demo.service.OrderService;
import com.sun.mail.smtp.SMTPAddressFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller

public class FirstMainController {
    @Autowired
    private OrderService service;

    @Autowired
    HttpServletRequest request;


    @RequestMapping
    public String mainPage() {
       // model.addAttribute("orders", service.getLastTenOrderInSorted());
        return "redirect:/warspear/buyAccountYxi";
    }

    @RequestMapping("warspear/logout")
    public String logout() {
            HttpSession session = request.getSession(false);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            if (session != null) {
                session.invalidate();
            }

            SecurityContextHolder.clearContext();
            return "redirect:../warspear/buyAccountYxi";
    }
}
