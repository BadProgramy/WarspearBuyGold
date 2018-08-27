package article.example.demo.service;

import article.example.demo.dao.AnonimOrderRepository;
import article.example.demo.model.PaymentOrderAnonim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class AnonimOrderService {

    @Autowired
    private AnonimOrderRepository anonimOrderRepository;

    @Autowired
    private DataSource dataSource;

    public void save(PaymentOrderAnonim paymentOrderAnonim) throws SQLException {
        RequestPostConnection.requestions(dataSource);
        anonimOrderRepository.save(paymentOrderAnonim);
    }
}
