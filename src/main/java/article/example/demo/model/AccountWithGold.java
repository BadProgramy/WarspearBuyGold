package article.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountWithGold {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String gold;
    private Number amount;
    private String service;
    private String login;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}