package article.example.demo.service;

import article.example.demo.dao.OrderRepository;
import article.example.demo.model.Order;
import article.example.demo.model.Status;
import article.example.demo.model.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DataSource dataSource;

    private static final int DEFAULT_LIST_FOR_OUTPUT_IN_MAIN = 10;

    @Transactional
    public void save(Order order) throws SQLException {
        /*Connection connection = dataSource.getConnection();
        PreparedStatement statementOne = connection.prepareStatement("set character set utf8");
        PreparedStatement statementTwo = connection.prepareStatement("set names utf8");
        statementOne.execute();
        statementTwo.execute();
        statementOne.close();
        statementTwo.close();
        connection.close();*/
        RequestPostConnection.requestions(dataSource);
        orderRepository.save(order);
    }

    public List<Order> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(orderRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByUser(User user) {
        List<Order> orders = new ArrayList<>();
        for (Order order: getAll()) {
            if (order.getUser().equals(user))
                orders.add(order);
        }
        return orders;
    }

    public boolean isOrderProcessing(User user) {
        List<Order> orders = getOrdersByUser(user);
        for (Order order: orders) {
            if (order.getStatus().equals(Status.IDET_VYSTAVLENIE_SCHETA) ||
                    order.getStatus().equals(Status.PROVERYETSY_OPLATA))
                return false;
        }
        return true;
    }

    public List<Order> getLastTenOrderInSorted(){
        List<Order> lastTenOrder = new ArrayList<>();
        for (Order order: getAll()) {
            if (lastTenOrder.size()<DEFAULT_LIST_FOR_OUTPUT_IN_MAIN && order.getStatus().equals(Status.OBRABOTAN))
                lastTenOrder.add(order);
             else if (lastTenOrder.size()==DEFAULT_LIST_FOR_OUTPUT_IN_MAIN-1) break;
        }
        return lastTenOrder;
    }

    public void delete(long idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
