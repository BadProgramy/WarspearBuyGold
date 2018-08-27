package article.example.demo.service;

import article.example.demo.dao.AccountWithGoldRepository;
import article.example.demo.model.AccountWithGold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWithGoldService {
    @Autowired
    private AccountWithGoldRepository accountWithGoldRepository;

    public AccountWithGold findOne(Number amount, String service) {
        AccountWithGold tempAcc;
        for (AccountWithGold accountWithGold: accountWithGoldRepository.findAll()) {
            if (accountWithGold.getAmount().equals(amount) &&
                    accountWithGold.getService().equals(service))
            {
                tempAcc = accountWithGold;
                accountWithGoldRepository.delete(accountWithGold);
                return tempAcc;
            }
        }
        return null;
    }
}
