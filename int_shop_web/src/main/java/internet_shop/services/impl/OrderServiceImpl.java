package internet_shop.services.impl;

import internet_shop.entities.Order;
import internet_shop.repository.OrderRepository;
import internet_shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getByUserId(Long id) {
        return orderRepository.getByUserId(id);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    public void deleteObj(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void add(Order order) {
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.saveAndFlush(order);
}

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void deleteId(Long id) {
        orderRepository.deleteById(id);
    }
}
