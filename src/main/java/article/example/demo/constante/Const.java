package article.example.demo.constante;

import article.example.demo.model.AccountWithGold;

public abstract class Const {
   public static final String serviceBuyGoldByYxi = "Покупка голд у ух";
   public static final String serviceBuyGoldByGory = "Покупка голд у гор";
   public static final String goldInAccountForPaymentInTwoK = "1к";
   public static final String goldInAccountForPaymentInTenK= "10к";
   public static final String goldInAccountForPaymentInFifty = "50к";
   public static final String goldInAccountForPaymentInHundred = "100к";
   public static final double amountInAccountForPaymentInTwoK = 2.0;
   public static final double amountInAccountForPaymentInTenK = 20.0;
   public static final double amountInAccountForPaymentInFiftyK = 100.0;
   public static final double amountInAccountForPaymentInHundredK = 200.0;

    public static final AccountWithGold accountWithGoldIsEmpty = new AccountWithGold("Обратитесь ему, так как у вас возникла ошибка: https://vk.com/id109488730",
            "Обратитесь ему, так как у вас возникла ошибка: https://vk.com/id109488730");

}
