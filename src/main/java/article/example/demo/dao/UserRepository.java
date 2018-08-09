package article.example.demo.dao;

import article.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
