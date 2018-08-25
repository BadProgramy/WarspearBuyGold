package article.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/warspear")
public class NotificationController {

    @Autowired
    private Sender sender;

    @RequestMapping(value = "/notification", method = {RequestMethod.POST} )
    public String notification(@RequestParam String notification_type,
                             @RequestParam String operation_id,
                             @RequestParam String label,
                             @RequestParam String datetime,
                             @RequestParam String email,
                             @RequestParam String sender,
                             @RequestParam String sha1_hash,
                             @RequestParam String currency,
                             @RequestParam boolean codepro
    ) {
        this.sender.send("Получилось", "notification_type = "+
                notification_type + " operation_id = " +
                        operation_id + " label = " +
        label + " datetime = " +
        datetime + " email = " +
        email + " sender = " +
        sender + " sha1_hash = " +
        sha1_hash + " currency = " +
        currency + " codepro = " +
        codepro, "myhytdinov@yandex.ru");
        return "notificationYM";
    }
}
