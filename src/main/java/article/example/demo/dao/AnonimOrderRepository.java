package article.example.demo.dao;

import article.example.demo.model.PaymentOrderAnonim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonimOrderRepository extends CrudRepository<PaymentOrderAnonim,Long> {
}
