package article.example.demo.dao;

import article.example.demo.model.AccountWithGold;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountWithGoldRepository extends CrudRepository<AccountWithGold, Long> {
}
