package article.example.demo.controller;

import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.MessageDigest;
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
                            /* @RequestParam Number amount,
                             @RequestParam Number withdraw_amount,*/
                             @RequestParam String sender,
                             @RequestParam String sha1_hash,
                             @RequestParam String currency,
                             @RequestParam boolean codepro
    ) {
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

        String paramString = String.format("{0}&{1}&{2}&{3}&{4}&{5}&{6}&{7}",
                notification_type, operation_id, currency, datetime , sender,
                String.valueOf(codepro).toLowerCase(), key, label);

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
        " sha1_hash = " + sha1_hash, "myhytdinov@yandex.ru");
        return "notificationYM";
    }

    public String GetHash(String base)
    {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
