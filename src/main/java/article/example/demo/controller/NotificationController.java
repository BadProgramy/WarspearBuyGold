package article.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
                             @RequestParam(value = "email", required = false) String email,
                             /*@RequestParam Number withdraw_amount,*/
                             @RequestParam String sender,
                             @RequestParam String sha1_hash,
                             @RequestParam String currency,
                             @RequestParam boolean codepro

    ) throws NoSuchAlgorithmException {

        String key = "oy1lxrImQrIY2QLFiSVHljOy";

        String paramString =
                notification_type + "&" + operation_id+ "&" + amount + "&" + currency+ "&" + datetime
                        + "&" +sender+ "&" +
                String.valueOf(codepro)+ "&" + key+ "&" + label;

        String paramStringHash1 = GetHash(paramString);

        if (paramStringHash1.equals(sha1_hash) && !codepro)
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
        else
        {
            this.sender.send("Не получилось",
                    "paramStringHash1 = " + paramStringHash1 +
                            " sha1_hash = " + sha1_hash + " paramString = " +paramString
                    + " codepro = " + codepro, "myhytdinov@yandex.ru");
            this.sender.send("Не удалось проверить вашу оплату",
                    "Что-то произошло не так напишите ему https://vk.com/id109488730 и он все проверит",
                    "хз");
        }
        return "notificationYM";
    }

/*
    @RequestMapping(value = "/notification", method = {RequestMethod.POST} )
    public String notification(@RequestParam String notification_type,
                               @RequestParam String operation_id,
                               @RequestParam String label,
                               @RequestParam String datetime,
                               @RequestParam Number amount,
            *//*@RequestParam Number withdraw_amount,*//*
                               @RequestParam String sender,
                               @RequestParam String sha1_hash,
                               @RequestParam String currency,
                               @RequestParam boolean codepro,
                               @RequestParam boolean unaccepted

    ) throws NoSuchAlgorithmException {

        String key = "oy1lxrImQrIY2QLFiSVHljOy";

        String paramString =
                notification_type + "&" + operation_id+ "&" + amount + "&" + currency+ "&" + datetime
                        + "&" +sender+ "&" +
                        String.valueOf(codepro)+ "&" + key+ "&" + label;

        String paramStringHash1 = GetHash(paramString);

        if (paramStringHash1.equals(sha1_hash) && !codepro && !unaccepted)
        {
            this.sender.send("Получилось", "notification_type = "+
                    notification_type + " operation_id = " +
                    operation_id + " label = " +
                    label + " datetime = " +
                    datetime + " sender = " +
                    sender + " sha1_hash = " +
                    sha1_hash + " currency = " +
                    currency + " codepro = " +
                    codepro + " unaccepted = " +
                    unaccepted, "myhytdinov@yandex.ru");
        }
        else
        {
            this.sender.send("Не получилось",
                    "paramStringHash1 = " + paramStringHash1 +
                            " sha1_hash = " + sha1_hash + " paramString = " +paramString + " unaccepted = " + unaccepted
                            + " codepro = " + codepro, "myhytdinov@yandex.ru");
            this.sender.send("Не удалось проверить вашу оплату",
                    "Что-то произошло не так напишите ему https://vk.com/id109488730 и он все проверит",
                    "хз");
        }
        return "notificationYM";
    }*/

    private String GetHash(String base) throws NoSuchAlgorithmException {

        byte[] key = base.getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] hash = md.digest(key);

        String result = "";
        for (int i = 0; i < hash.length; i++)
        {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) hex = "0" + hex;
            hex = hex.substring(hex.length() - 2);
            result += hex;
        }
        return result;
    }
}
