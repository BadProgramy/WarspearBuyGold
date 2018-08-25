package article.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
                             @RequestParam Float amount,
                             @RequestParam Float withdraw_amount,
                             @RequestParam String sender,
                             @RequestParam String sha1_hash,
                             @RequestParam String currency,
                             @RequestParam Boolean codepro) {
        this.sender.send("Получилось",
                notification_type + " \n" +
                        operation_id + " \n" +
        label + " \n" +
        datetime + " \n" +
        String.valueOf(amount) + " \n" +
        String.valueOf(withdraw_amount) + " \n" +
        sender + " \n" +
        sha1_hash + " \n" +
        currency + " \n" +
        codepro, "myhytdinov@yandex.ru");
        return "notificationYM";
    }
}
