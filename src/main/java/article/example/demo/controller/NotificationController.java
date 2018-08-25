package article.example.demo.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/warspear")
public class NotificationController {

    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public String notification(String notification_type, String operation_id, String label, String datetime,
                                            Float amount, Float withdraw_amount, String sender, String sha1_hash, String currency, Boolean codepro) {
        return operation_id;
    }
}
