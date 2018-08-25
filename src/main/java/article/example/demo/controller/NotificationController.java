package article.example.demo.controller;

import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                             @RequestParam Number amount,
                             /*@RequestParam Number withdraw_amount,*/
                             @RequestParam String sender,
                             @RequestParam String sha1_hash,
                             @RequestParam String currency,
                             @RequestParam boolean codepro
    ) throws NoSuchAlgorithmException {
       /* this.sender.send("Получилось", "notification_type = "+
                notification_type + " operation_id = " +
                        operation_id + " label = " +
        label + " datetime = " +
                *//*amount + " withdraw_amount = " +
                        withdraw_amount + " datetime = " +*//*
        datetime + " sender = " +
        sender + " sha1_hash = " +
        sha1_hash + " currency = " +
        currency + " codepro = " +
        codepro, "myhytdinov@yandex.ru");*/

        String key = "oy1lxrImQrIY2QLFiSVHljOy";

        String paramString =
                notification_type + "&" + operation_id+ "&" + amount + "&" + currency+ "&" + datetime
                        + "&" +sender+ "&" +
                String.valueOf(codepro)+ "&" + key+ "&" + label;

        String paramStringHash1 = GetHash(paramString);

        if (paramStringHash1.equals(sha1_hash))
        {
            this.sender.send("Получилось", "notification_type = "+
                    notification_type + " operation_id = " +
                    operation_id + " label = " +
                    label + " datetime = " +
            datetime + " sender = " +
                    sender + " sha1_hash = " +
                    sha1_hash + " currency = " +
                    currency + " codepro = " +
                    codepro, "myhytdinov@yandex.ru");
        }
        else this.sender.send("Не получилось",
                "paramStringHash1 = " + paramStringHash1 +
        " sha1_hash = " + sha1_hash + " paramString = " +paramString, "myhytdinov@yandex.ru");
        return "notificationYM";
    }

    public String GetHash(String base) throws NoSuchAlgorithmException {

        byte[] key = base.getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] hash = md.digest(key);

        String result = "";
        for (byte b : hash) {
            result += Integer.toHexString(b + 256);
        }

        return result;
    }
}
