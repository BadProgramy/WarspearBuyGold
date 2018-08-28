package article.example.demo.controller;

import article.example.demo.constante.Const;
import article.example.demo.model.AccountWithGold;
import article.example.demo.model.PaymentOrderAnonim;
import article.example.demo.service.AccountWithGoldService;
import article.example.demo.service.AnonimOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/warspear")
public class AnonimOrderController {

    @Autowired
    private AnonimOrderService anonimOrderService;

    @Autowired
    private AccountWithGoldService accountWithGoldService;

    private PaymentOrderAnonim paymentOrderAnonim;

    @RequestMapping("/buyAccountYxi")
    public String buyAccountYxi(Model model) throws SQLException, CloneNotSupportedException {
        model.addAttribute("paymentOrderAnonim", new PaymentOrderAnonim());

        model.addAttribute("isEmptyTwoKInYxi", accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByYxi).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyTenKInYxi", accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByYxi).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyFiftyKInYxi", accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByYxi).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyHundredKInYxi", accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByYxi).equals(Const.accountWithGoldIsEmpty));

        return "buyAccountYxi";
    }

    @RequestMapping("/buyAccountGory")
    public String buyAccountGory(Model model) throws SQLException, CloneNotSupportedException {
        model.addAttribute("paymentOrderAnonim", new PaymentOrderAnonim());

        model.addAttribute("isEmptyTwoKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyTenKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyFiftyKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyHundredKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));

        return "buyAccountGory";
    }

    /*@RequestMapping("/buyAccountYxi/submit/twoThousand")
    public String buyAccountYxiSubmitTwoThousand(@ModelAttribute PaymentOrderAnonim paymentOrderAnonim) throws SQLException {
        paymentOrderAnonim.setGold("2к");
        paymentOrderAnonim.setCost("4 руб.");
        paymentOrderAnonim.setService(BUY_GOLD_YXI);
        this.paymentOrderAnonim = paymentOrderAnonim;
        anonimOrderService.save(paymentOrderAnonim);
        return "redirect:../../payment";//тут нужен редирект на эту страницу
    }

    @RequestMapping("/buyAccountYxi/submit/tenThousand")
    public String buyAccountYxiSubmitTenThousand(@ModelAttribute PaymentOrderAnonim paymentOrderAnonim) throws SQLException {
        paymentOrderAnonim.setGold("10к");
        paymentOrderAnonim.setCost("20 руб.");
        paymentOrderAnonim.setService(BUY_GOLD_YXI);
        this.paymentOrderAnonim = paymentOrderAnonim;
        anonimOrderService.save(paymentOrderAnonim);
        return "redirect:../../payment";//тут нужен редирект на эту страницу
    }

    @RequestMapping("/buyAccountYxi/submit/fiftyThousand")
    public String buyAccountYxiSubmitFiftyThousand(@ModelAttribute PaymentOrderAnonim paymentOrderAnonim) throws SQLException {
        paymentOrderAnonim.setGold("50к");
        paymentOrderAnonim.setCost("100 руб.");
        paymentOrderAnonim.setService(BUY_GOLD_YXI);
        this.paymentOrderAnonim = paymentOrderAnonim;
        anonimOrderService.save(paymentOrderAnonim);
        return "redirect:../../payment";//тут нужен редирект на эту страницу
    }

    @RequestMapping("/buyAccountYxi/submit/hundredThousand")
    public String buyAccountYxiSubmitHundredThousand(@ModelAttribute PaymentOrderAnonim paymentOrderAnonim) throws SQLException {
        paymentOrderAnonim.setGold("100к");
        paymentOrderAnonim.setCost("200 руб.");
        paymentOrderAnonim.setService(BUY_GOLD_YXI);
        this.paymentOrderAnonim = paymentOrderAnonim;
        anonimOrderService.save(paymentOrderAnonim);
        return "redirect:../../payment";//тут нужен редирект на эту страницу
    }

    @RequestMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("paymentOrderAnonim", paymentOrderAnonim);
        return "formForPayment";
    }*/
}
