package article.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/warspear")
public class NotificationController {

    @Autowired
    private Sender sender;

    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public void notification(String notification_type, String operation_id, String label, String datetime,
                                            Float amount, Float withdraw_amount, String sender, String sha1_hash, String currency, Boolean codepro) {
        this.sender.send("Получилось",
                notification_type + " \n"+
                        operation_id + " \n" +
        label + " \n" +
        datetime + " \n" +
        String.valueOf(amount) + " \n" +
        String.valueOf(withdraw_amount) + " \n" +
        sender + " \n" +
        sha1_hash + " \n" +
        currency + " \n" +
        codepro, "myhytdinov@yandex.ru");
    }
}
