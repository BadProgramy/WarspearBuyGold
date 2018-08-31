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

    public AccountWithGold findOne(Double amount, String service) throws SQLException, CloneNotSupportedException {
        AccountWithGold tempAcc = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from account_with_gold where amount = ? and service = ?");
        preparedStatement.setDouble(1, amount);
        preparedStatement.setString(2, service);
        ResultSet resultSet = preparedStatement.executeQuery();


        //if (resultSet.next()) {
            tempAcc = new AccountWithGold();
            tempAcc.setLogin(resultSet.getString("login"));
            tempAcc.setPassword(resultSet.getString("password"));
            tempAcc.setId(resultSet.getLong("id"));
            tempAcc.setGold(resultSet.getString("gold"));
            tempAcc.setAmount(resultSet.getDouble("amount"));
            tempAcc.setService(resultSet.getString("service"));

       // }
        Sender sender = new Sender();
        sender.send("Проверка","Логин - " + tempAcc.getLogin() + " Пароль - " + tempAcc.getPassword(),"myhytdinov@yandex.ru");
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (tempAcc.getLogin()==null || tempAcc.getPassword()==null) return Const.accountWithGoldIsEmpty;
        return tempAcc;
    }

    public void delete(long id) {
        accountWithGoldRepository.deleteById(id);
    }
}
