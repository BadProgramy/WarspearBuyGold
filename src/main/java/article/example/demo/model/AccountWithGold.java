package article.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AccountWithGold implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String gold;
    private Double amount;
    private String service;
    private String login;
    private String password;
    private String operationId;

    public AccountWithGold() {
    }

    public AccountWithGold(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AccountWithGold(AccountWithGold accountWithGold) {
        this.id = accountWithGold.getId();
        this.gold = accountWithGold.getGold();
        this.amount = accountWithGold.getAmount();
        this.service = accountWithGold.getService();
        this.login = accountWithGold.getLogin();
        this.password = accountWithGold.getPassword();
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new AccountWithGold(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass()!=obj.getClass()) return false;
        if (obj==null) return false;

        AccountWithGold object = (AccountWithGold)obj;
        return (this.getLogin().equals(object.getLogin()) &&
                this.getPassword().equals(object.getPassword()));
    }
}
