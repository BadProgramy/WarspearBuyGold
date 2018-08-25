package article.example.demo.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/warspear")
public class NotificationController {

    @RequestMapping("/notification")
    public Map<String, Object> notification(@ModelAttribute JSONObject notification) {
        return notification.toMap();
    }
}
