package article.example.demo.service;

import article.example.demo.dao.UserRepository;
import article.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public void save(User User) {
        userRepository.save(User);
    }

    public List<User> getAll() {
        List<User> temp = new ArrayList<>();
        userRepository.findAll().forEach(temp::add);
        return temp;
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByName(username);
        if (user!=null) return user;
        else throw new UsernameNotFoundException("Пользователь " + username + " не был найден!");
    }


    public User findUserByName(@NotNull String username) {
        for (User user: userRepository.findAll()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
