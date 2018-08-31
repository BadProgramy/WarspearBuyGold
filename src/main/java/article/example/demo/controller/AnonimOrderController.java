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

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByYxi).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByYxi).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyTwoKInYxi", true);
        else model.addAttribute("isEmptyTwoKInYxi", true);

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByYxi).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByYxi).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyTenKInYxi", true);
        else model.addAttribute("isEmptyTenKInYxi", true);

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByYxi).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByYxi).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyFiftyKInYxi", true);
        else model.addAttribute("isEmptyFiftyKInYxi", false);

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByYxi).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByYxi).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyHundredKInYxi", true);
        else model.addAttribute("isEmptyHundredKInYxi", false);

        //model.addAttribute("isEmptyHundredKInYxi", accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByYxi).equals(Const.accountWithGoldIsEmpty));

        return "buyAccountYxi";
    }

    @RequestMapping("/buyAccountGory")
    public String buyAccountGory(Model model) throws SQLException, CloneNotSupportedException {
        model.addAttribute("paymentOrderAnonim", new PaymentOrderAnonim());


        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByGory).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByGory).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyTwoKInGory", true);
        else model.addAttribute("isEmptyTwoKInGory", false);

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByGory).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByGory).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyTenKInGory", true);
        else model.addAttribute("isEmptyTenKInGory", false);

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByGory).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByGory).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyFiftyKInGory", true);
        else model.addAttribute("isEmptyFiftyKInGory", false);

        if (accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByGory).getLogin().equals(Const.accountWithGoldIsEmpty.getLogin()) &&
                accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByGory).getPassword().equals(Const.accountWithGoldIsEmpty.getPassword()))
            model.addAttribute("isEmptyHundredKInGory", true);
        else model.addAttribute("isEmptyHundredKInGory", false);

        /*model.addAttribute("isEmptyTwoKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInTwoK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyTenKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInTenK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyFiftyKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInFiftyK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
        model.addAttribute("isEmptyHundredKInGory", accountWithGoldService.findOne(Const.amountInAccountForPaymentInHundredK,Const.serviceBuyGoldByGory).equals(Const.accountWithGoldIsEmpty));
*/
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
