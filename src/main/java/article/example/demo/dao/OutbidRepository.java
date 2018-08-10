package article.example.demo.dao;

import article.example.demo.model.Outbid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutbidRepository extends CrudRepository<Outbid,Long> {
}
