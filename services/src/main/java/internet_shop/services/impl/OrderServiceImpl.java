package internet_shop.services.impl;

import internet_shop.dao.OrderDao;
import internet_shop.entities.Order;
import internet_shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderDao orderDao;


    public List<Order> getByUserId(Long orderId) {
        try {
            return orderDao.getByUserId(orderId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting all Orders");
        }
    }

    public Order create(Order order) {
        if (order != null) {
            return (Order) orderDao.add(order);
        }
        return order;
    }

    public void deleteObj(Order order) {
        if (order != null) {
            orderDao.delete(order.getId());
        }
    }

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public Order get(Long id) {
        return (Order) orderDao.get(id);
    }

    @Override
    public void deleteId(Long id) {
        orderDao.delete(id);
    }
}
