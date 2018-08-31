package article.example.demo.service;

import article.example.demo.constante.Const;
import article.example.demo.controller.Sender;
import article.example.demo.dao.AccountWithGoldRepository;
import article.example.demo.model.AccountWithGold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

@Service
public class AccountWithGoldService {
    @Autowired
    private AccountWithGoldRepository accountWithGoldRepository;

    @Autowired
    private DataSource dataSource;

    public AccountWithGold findOne(Double amount, String service) {
        for (AccountWithGold accountWithGold: accountWithGoldRepository.findAll()) {
            if (accountWithGold.getAmount().equals(amount) &&
                    accountWithGold.getService().equals(service) &&
                    (accountWithGold.getOperationId() == null || accountWithGold.getOperationId() == "")) return accountWithGold;
        }
        return Const.accountWithGoldIsEmpty;

        /*AccountWithGold tempAcc = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from account_with_gold where amount = ? and service = ?");
        preparedStatement.setDouble(1, amount);
        preparedStatement.setString(2, service);
        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            tempAcc = new AccountWithGold();
            tempAcc.setLogin(resultSet.getString("login"));
            tempAcc.setPassword(resultSet.getString("password"));
            tempAcc.setId(resultSet.getLong("id"));
            tempAcc.setGold(resultSet.getString("gold"));
            tempAcc.setAmount(resultSet.getDouble("amount"));
            tempAcc.setService(resultSet.getString("service"));
            Sender sender = new Sender();
            sender.send("Проверка","Логин - " + tempAcc.getLogin() + " Пароль - " + tempAcc.getPassword(),"myhytdinov@yandex.ru");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (tempAcc==null) return Const.accountWithGoldIsEmpty;
        return tempAcc;*/
    }

    public void delete(long id) {
        accountWithGoldRepository.deleteById(id);
    }

    public void save(AccountWithGold accountWithGold) {
        accountWithGoldRepository.save(accountWithGold);
    }

    public AccountWithGold findAccountByOperationId(String operationId) {
        for (AccountWithGold accountWithGold: accountWithGoldRepository.findAll()) {
            if (accountWithGold.getOperationId()==operationId) return accountWithGold;
        }
        return null;
    }
}
