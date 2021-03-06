package article.example.demo.model;

import org.springframework.boot.util.LambdaSafe;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;//почта
    private String password;
    private boolean accountNonExpired = true;//если давно не заходили
    private boolean accountNonLocked = true;//если заблокированный
    private boolean credentialsNonExpired = true; //если настройка учетных данных истекли
    private boolean enabled = true;//активированный

    private String firstname;
    private String secondname;
    private String pagevk;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id"))
    @Enumerated(EnumType.STRING)
    private List<Role> role;

    /*@ManyToOne
    @JoinTable(name = "users", inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JoinColumn(name = "order_id")
    private List<Order> orders;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPagevk() {
        return pagevk;
    }

    public void setPagevk(String pagevk) {
        this.pagevk = pagevk;
    }

    public List<Role> getRole() {
        return role;
    }

    /*public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    public void update(User user) {
        if (user.getUsername()!=null)
            username = user.getUsername();
        if (user.getPassword()!=null)
            password = user.getPassword();
        if (user.getFirstname()!=null)
            firstname = user.getFirstname();
        if (user.getSecondname()!=null)
            secondname = user.getSecondname();
        if (user.getPagevk()!=null)
            pagevk = user.getPagevk();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null) return false;
        if (this.getClass()!=obj.getClass()) return false;
        User Object = (User) obj;
        return (getUsername().equals(Object.getUsername()));
    }
}
