package internet_shop.services;

import internet_shop.entities.Order;

import java.util.List;

public interface OrderService extends SERVICE<Order>{

    Order create(Order order);
    void deleteObj(Order order);

    //Order createOrder(Long userId, Long productId, Integer quantity);
    List<Order> getByUserId(Long userId);

}
